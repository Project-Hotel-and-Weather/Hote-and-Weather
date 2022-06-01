package pl.sda.hotelweatherproject.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.model.Weather;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.awt.*;
import java.io.IOException;
import java.util.Collections;

@RestController
public class PerfectionLocation {

    private final HotelService hotelService;
    private final WeatherService weatherService;


    public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
        this.hotelService = hotelService;
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/weather")
    public Weather getWeatherInfo(
//            @RequestParam Double longitude,
//            @RequestParam Double latitude)
    )throws IOException {

        return weatherService.getWeatherInfo();
    }

    @GetMapping(value = "/hotel")
    public HotelModel getHotelInfo() throws IOException {
        return hotelService.getHotelInfo();
    }



//    @GetMapping("/hotel?location={location}&date={date}")
//    public String getHotel(@PathVariable(value = "location") String location,
//                           @PathVariable(value = "date") Date date) throws IOException {
//        hotelService.getHotelInfo();
//        weatherService.getWeatherInfo();
//
//    }
//
}
