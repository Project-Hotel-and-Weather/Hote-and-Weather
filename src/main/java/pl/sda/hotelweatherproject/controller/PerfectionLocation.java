package pl.sda.hotelweatherproject.controller;

import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;
import java.util.Date;

@Controller
public class PerfectionLocation {

    private final HotelService hotelService;
    private final WeatherService weatherService;


    public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
        this.hotelService = hotelService;
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) throws IOException, ParseException {
        model.addAttribute("city",hotelService.getHotelInfo());
        model.addAttribute("weather", weatherService.getWeatherInfo());
        return "index";
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
