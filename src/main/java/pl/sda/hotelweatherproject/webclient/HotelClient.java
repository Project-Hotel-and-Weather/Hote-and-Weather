package pl.sda.hotelweatherproject.webclient;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class HotelClient {

    public String getHotel(String lat, String lon) throws UnirestException {
        HttpResponse<String> response = Unirest.get(
                        "https://sandbox.impala.travel/v1/hotels?start=2022-07-11&end=2022-07-19&latitude={lat}&longitude={long}&radius=25000")
                .header("x-api-key", "sandb_3RKOMF9H9pTeIRu5ZXSNuSUuJfKQALIzPlakXCZk")
//               .routeParam("startDate", String.valueOf(startDate))
//               .routeParam("endDate", String.valueOf(endDate))
                .routeParam("lat", lat)
                .routeParam("long", lon)
                .asString();
        return response.getBody();


    }
}
