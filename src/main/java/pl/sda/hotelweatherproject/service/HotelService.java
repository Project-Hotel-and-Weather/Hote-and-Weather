package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.minidev.json.parser.ParseException;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.jsonClient.CityClient;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.response.*;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;
import pl.sda.hotelweatherproject.webclient.HotelClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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

    public List<HotelModel> getHotelInfo(String location, String con) throws IOException, UnirestException, ParseException {
        List<String> localization = cityClient.findLocation(location, con);
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
        if (response.getData().isEmpty()) {
            hotelsList.add(HotelModel.builder()
                    .city(WordUtils.capitalizeFully(location))
                    .countryName(WordUtils.capitalizeFully(con))
                    .build());
        }

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
                    amount = amount *.1;
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
        return hotelsList;
    }

    private Double convertCurrency(String code, Double amount) throws JsonProcessingException {
        String response = exchangeClient.getExchangeForCurrency(code);
        ObjectMapper mapper = new ObjectMapper();
        Example example = mapper.readValue(response, Example.class);
        Double mid = example.getRates().get(0).getMid();
        return Math.round((amount / mid) * 100) / 100.00;
    }


}
