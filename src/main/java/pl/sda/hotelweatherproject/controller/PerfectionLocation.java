package pl.sda.hotelweatherproject.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.service.HotelService;
import pl.sda.hotelweatherproject.service.WeatherService;

import java.io.IOException;
import java.util.Date;
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

  @GetMapping(value = "/weather&{location}&{country}")
  public WeatherModel getWeatherInfo(
         @PathVariable (value = "location") String location,
         @PathVariable (value = "country") String con)
          throws IOException {
    return weatherService.getWeatherInfo(location, con);
  }

  @GetMapping(value = "/hotel&{location}&{country}")
  public List<HotelModel> getHotelInfo(
          @PathVariable (value = "location") String location,
          @PathVariable (value = "country") String con)
//          @RequestParam Date startDate,
//          @RequestParam Date endDate)
          throws Exception {
    return hotelService.getHotelInfo(location, con);
  }
}
