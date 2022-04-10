package pl.sda.hotelweatherproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ServerWebExchange;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.util.Date;

@Controller
public class PerfectionLocation {

    private final HotelService hotelService;
    private final WeatherService weatherService;

    private final String secretHotel = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDk1ODMyNzEsImlhdCI6MTY0OTU4MTQ3MSwibmJmIjoxNjQ5NTgxNDcxLCJpZGVudGl0eSI6MTIxNn0.rku-Vy1EpXktGJlNT7XPfrVGTFunCZIdSoF8GTncco4";
    private final String secretWeather = "2d75c857e890f7742729cf3b29c7631f";

    public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
        this.hotelService = hotelService;
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getHomePage(){
        return index.html;
    }

    @GetMapping("/hotel?location={location}&date={date}")
    public String getHotel(@PathVariable(value = "location") String location,
                           @PathVariable(value = "date") Date date) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", secretHotel);
        hotelService.getHotelInfo(location, date);
        weatherService.getWeatherInfo(location, date);
        return hotels.html;
    }
}
