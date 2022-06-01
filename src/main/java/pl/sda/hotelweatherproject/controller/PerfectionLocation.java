package pl.sda.hotelweatherproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;

@Controller
public class PerfectionLocation {

    private final HotelService hotelService;
    private final WeatherService weatherService;


    public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
        this.hotelService = hotelService;
        this.weatherService = weatherService;
    }

    @GetMapping("/search")
    public String getHomePage(
            @RequestParam Double longitude,
            @RequestParam Double latitude) throws IOException {
        return hotelService.getHotelInfo() + weatherService.getWeatherInfo();
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
