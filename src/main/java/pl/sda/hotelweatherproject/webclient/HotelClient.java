package pl.sda.hotelweatherproject.webclient;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Component
public class HotelClient {

    public String getHotel(String lat, String lon) throws UnirestException {
        LocalDate now = LocalDate.now();
        LocalDate plus = now.plus(7, ChronoUnit.DAYS);

        HttpResponse<String> response = Unirest.get(
                        "https://sandbox.impala.travel/v1/hotels?start={startDate}&end={endDate}&latitude={lat}&longitude={long}&radius=25000")
                .header("x-api-key", "sandb_3RKOMF9H9pTeIRu5ZXSNuSUuJfKQALIzPlakXCZk")
                .routeParam("startDate", String.valueOf(now))
                .routeParam("endDate", String.valueOf(plus))
                .routeParam("lat", lat)
                .routeParam("long", lon)
                .asString();
        return response.getBody();


    }
}
