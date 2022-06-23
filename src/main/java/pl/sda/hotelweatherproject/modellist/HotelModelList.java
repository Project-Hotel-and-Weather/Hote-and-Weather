package pl.sda.hotelweatherproject.modellist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.convertcurrency.ConvertCurrency;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.response.hotelimpalaresponse.*;
import pl.sda.hotelweatherproject.webclient.HotelClient;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
@Component
public class HotelModelList {

    private final HotelClient hotelClient;
    private final ConvertCurrency convertCurrency;

    public HotelModelList(HotelClient hotelClient, ConvertCurrency convertCurrency) {
        this.hotelClient = hotelClient;
        this.convertCurrency = convertCurrency;
    }


    public List<HotelModel> getReaderForHotel(List<HotelModel> hotelsList, String lat, String lon) throws UnirestException, JsonProcessingException {
        Reader inputString = new StringReader(hotelClient.getHotel(lat, lon));
        BufferedReader bufferedReader = new BufferedReader(inputString);
        Gson gson = new Gson();
        Response response = gson.fromJson(bufferedReader, Response.class);
        String name = "";
        String code = "";
        Double amount = 0.0;
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
                        Double price = convertCurrency.getConvertCurrency(code, amount);
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
}
