package pl.sda.hotelweatherproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HotelAndWeatherController {

  private final HotelService hotelService;

  private final WeatherService weatherService;

  public HotelAndWeatherController(HotelService hotelService, WeatherService weatherService) {
    this.hotelService = hotelService;
    this.weatherService = weatherService;
  }

  @GetMapping(value = "/weather")
  public List<WeatherModel> getWeatherInfo(
          @RequestParam String location)
          throws IOException {
    return weatherService.getWeatherInfo(location);
  }

  @GetMapping(value = "/hotel")
  public List<HotelModel> getHotelInfo(
          @RequestParam String location)
          throws Exception {
    return hotelService.getHotelInfo(location);
  }
}
