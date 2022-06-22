package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.jsonClient.CityClient;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.response.*;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;
import pl.sda.hotelweatherproject.webclient.HotelClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HotelService {

    private final HotelClient hotelClient;

    private final ExchangeClient exchangeClient;

    private final CityClient cityClient;

    public HotelService(HotelClient hotelClient, ExchangeClient exchangeClient, CityClient cityClient) {
        this.hotelClient = hotelClient;
        this.exchangeClient = exchangeClient;
        this.cityClient = cityClient;
    }

    public List<HotelModel> getHotelInfo(String location) throws Exception {
        List<String> localization = cityClient.findLocation(location);
        String lon = localization.get(1);
        String lat = localization.get(0);
        Reader inputString = new StringReader(hotelClient.getHotel(lat, lon));
        BufferedReader bufferedReader = new BufferedReader(inputString);
        Gson gson = new Gson();
        Response response = gson.fromJson(bufferedReader, Response.class);
        String name = "";
        String code = "";
        List<HotelModel> hotelsList = new ArrayList<>();
        Double amount = 0.0;
        String position = lat + "," + lon;
        List<HotelModel> hotelMockModel = getHotelMockModel(gson, hotelsList, position);
        if (!response.getData().isEmpty()) {
            for (Datum datum : response.getData()) {
                List<String> formattedList = new ArrayList<>();
                List<String> imagesList = new ArrayList<>();
                for (int j = 0; j < datum.getAmenities().size(); j++) {
                    String formatted = datum.getAmenities().get(j).getFormatted();
                    formattedList.add(formatted);
                }
                for (int i = 0; i < datum.getImages().size(); i++) {
                    String url = datum.getImages().get(i).getUrl();
                    imagesList.add(url);
                }
                name = datum.getName();

                String line1 = datum.getAddress().getLine1();
                String city = datum.getAddress().getCity();
                String countryName = datum.getAddress().getCountryName();

                for (RoomType roomtype : datum.getRoomTypes()) {
                    String roomName = roomtype.getName();
                    String roomDescription = roomtype.getDescription();
                    for (Rates rates : roomtype.getRates()) {
                        amount = Double.valueOf(rates.getRetailRate().getTotal().getAmount());
                        amount = amount * .1;
                        for (CancellationPolicy cancellationPolicies : rates.getCancellationPolicies()) {
                            code = cancellationPolicies.getFee().getPrice().getCurrency().getCode();
                            Double price = convertCurrency(code, amount);
                            hotelsList.add(HotelModel.builder()
                                    .name(name)
                                    .price(price)
                                    .formatted(formattedList)
                                    .countryName(countryName)
                                    .roomName(roomName)
                                    .roomDescription(roomDescription)
                                    .line1(line1)
                                    .city(city)
                                    .url(imagesList)
                                    .build());
                            break;
                        }
                    }
                }
            }
        } else {
            return hotelMockModel;
        }
        return hotelsList;
    }

    private List<HotelModel> getHotelMockModel(Gson gson, List<HotelModel> hotelsList, String position) throws Exception {
        String formattedAddress = "";
        String entityName = "";
        String roomTypeString = "";
        double price = 0.0;
        List<String> finalFormatted;
        double rangeMin = 2500.00;
        double rangeMax = 3500.00;
        Random r = new Random();

        Set<String> formatted = Stream.of(
                "Air conditioning",
                "Currency exchange",
                "Housekeeping ",
                "Indoor parking",
                "Restaurant",
                "Room service",
                "Tour/sightseeing desk",
                "Accessible parking",
                "Lounges/bars",
                "Street side parking",
                "Secured parking",
                "Heated guest rooms",
                "Snack bar",
                "24-hour front desk",
                "Pool",
                "Solarium",
                "Non-smoking rooms (generic)",
                "Fitness Center").collect(Collectors.toSet());
        int min = 3;
        int max = 16;

        int minRoomType = 1;
        int maxRoomType = 4;

        List<String> roomType = new ArrayList<>(Arrays.asList("Single", "Double", "Triple", "Quad", "Queen"));


        String json = readUrl("https://dev.virtualearth.net/REST/v1/LocationRecog/" + position + "?distanceunit=km&verboseplacenames=true&key=AklnsAa0muLm2KviSVH5U6hR1pP2JVDiaBu1Gp_IP-hVIwNDpWttJ0BWCkPVOM8G&radius=2&type=Hotels");
        HotelAddress hotelAddress = gson.fromJson(json, HotelAddress.class);
        for (ResourceSet resourceSets : hotelAddress.getResourceSets()) {
            int range = 0;
            for (Resource resource : resourceSets.getResources()) {
                for (BusinessesAtLocation businessesAtLocation : resource.getBusinessesAtLocation()) {
                    String locality = businessesAtLocation.getBusinessAddress().getLocality();
                    if (businessesAtLocation.getBusinessInfo().getType().equals("Hotels")) {
                        formattedAddress = businessesAtLocation.getBusinessAddress().getFormattedAddress();
                        entityName = businessesAtLocation.getBusinessInfo().getEntityName();
                        int rangeRoomType = r.nextInt(maxRoomType - minRoomType) + minRoomType;
                        for (int i = 0; i < rangeRoomType; i++) {
                            roomTypeString = roomType.get(rangeRoomType);
                        }
                        price = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                        double price2 = Math.round(price * 100.0) / 100.0;


                        range = r.nextInt(max - min) + min;
                        finalFormatted = new ArrayList<>(range);
                        for (int i = 0; i < range; i++) {
                            Iterator<String> iterator = formatted.iterator();
                            String next = null;
                            while (iterator.hasNext()) {
                                next = iterator.next();
                                if (i < range) {
                                    finalFormatted.add(next);
                                    i++;
                                }
                            }
                        }
                        hotelsList.add(HotelModel.builder()
                                .city(WordUtils.capitalizeFully(locality))
                                .line1(formattedAddress)
                                .name(entityName)
                                .roomName(roomTypeString)
                                .price(price2)
                                .formatted(finalFormatted)
                                .build());
                    }
                }
            }
        }
        return hotelsList;
    }

    private Double convertCurrency(String code, Double amount) throws JsonProcessingException {
        String response = exchangeClient.getExchangeForCurrency(code);
        ObjectMapper mapper = new ObjectMapper();
        Example example = mapper.readValue(response, Example.class);
        Double mid = example.getRates().get(0).getMid();
        return Math.round((amount / mid) * 100) / 100.00;
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }


}
