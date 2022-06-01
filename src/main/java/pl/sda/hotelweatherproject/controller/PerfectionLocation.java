package pl.sda.hotelweatherproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class PerfectionLocation {

    private final HotelService hotelService;
    private final WeatherService weatherService;


    public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
        this.hotelService = hotelService;
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/weather")
    public WeatherModel getWeatherInfo(
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
