package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Example;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;
import pl.sda.hotelweatherproject.webclient.HotelClient;
import pl.sda.impala.response.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelClient hotelClient;
    private final ExchangeClient exchangeClient;

    public String getHotelInfo() throws IOException {

        String path = "src/main/resources/response.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        Response response = gson.fromJson(bufferedReader, Response.class);
        String name = "";
        String code = "";
        Integer amount = 0;
        for (Datum datum : response.getData()) {
            name = datum.getName();
            for (RoomType roomtype : datum.getRoomTypes()) {
                for (Rates rates : roomtype.getRates()) {
                    for (CancellationPolicy cancellationPolicies : rates.getCancellationPolicies()) {
                        code = cancellationPolicies.getFee().getPrice().getCurrency().getCode();
                        amount = cancellationPolicies.getFee().getPrice().getAmount();
                    }
                }
            }
        }
        Double price = convertCurrency(code, amount);
        return name + " " + code + " " + price;
    }

    public Double convertCurrency(String code, Integer amount) throws JsonProcessingException {
        String response = exchangeClient.getExchangeForCurrency(code);
        ObjectMapper mapper = new ObjectMapper();
        Example example = mapper.readValue(response, Example.class);
        Double mid = example.getRates().get(0).getMid();
        return Math.round((amount / mid) * 100) / 100.00;
    }
}
