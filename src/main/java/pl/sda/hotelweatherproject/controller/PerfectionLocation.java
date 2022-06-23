package pl.sda.hotelweatherproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PerfectionLocation {

  @Autowired
  private final HotelService hotelService;
  @Autowired
  private final WeatherService weatherService;

  public PerfectionLocation(HotelService hotelService, WeatherService weatherService) {
    this.hotelService = hotelService;
    this.weatherService = weatherService;
  }

  @GetMapping(value = "/weather")
  public List<WeatherModel> getWeatherInfo(
          @RequestParam String location)
          throws IOException, ParseException {
    return weatherService.getWeatherInfo(location);
  }

  @GetMapping(value = "/hotel")
  public List<HotelModel> getHotelInfo(
          @RequestParam String location)
//          @RequestParam Date startDate,
//          @RequestParam Date endDate)
          throws Exception {
    return hotelService.getHotelInfo(location);
  }
}
