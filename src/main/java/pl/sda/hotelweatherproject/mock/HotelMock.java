package pl.sda.hotelweatherproject.mock;

import com.google.gson.Gson;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.response.buisnessaddressresponse.BusinessesAtLocation;
import pl.sda.hotelweatherproject.response.buisnessaddressresponse.HotelAddress;
import pl.sda.hotelweatherproject.response.buisnessaddressresponse.Resource;
import pl.sda.hotelweatherproject.response.buisnessaddressresponse.ResourceSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class HotelMock {
    public List<HotelModel> getHotelMockModel(List<HotelModel> hotelsList, String position) throws Exception {
        Gson gson = new Gson();
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
                        int price2 = (int) (Math.round(price * 100.0) / 100.0);


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
                                .price((double) price2)
                                .formatted(finalFormatted)
                                .build());
                    }
                }
            }
        }
        return hotelsList;
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
