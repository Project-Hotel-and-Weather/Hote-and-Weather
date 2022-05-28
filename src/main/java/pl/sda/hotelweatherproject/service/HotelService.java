package pl.sda.hotelweatherproject.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Comparision;
import pl.sda.hotelweatherproject.dtos.HotelName;
import pl.sda.hotelweatherproject.webclient.HotelClient;
import pl.sda.impala.response.Address;
import pl.sda.impala.response.Datum;
import pl.sda.impala.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelClient hotelClient;

    public String getHotelInfo() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/response.json")));

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Response hotelName = gson.fromJson(jsonString, Response.class);
        System.out.println(hotelName);

        jsonString = gson.toJson(hotelName);
        System.out.println(jsonString);

        return jsonString;
    }
}
