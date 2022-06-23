package pl.sda.hotelweatherproject.service;

import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.jsonClient.JsonCityFinder;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.modellist.WeatherModelList;
import pl.sda.hotelweatherproject.readers.Readers;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class WeatherService {

    private final JsonCityFinder jsonCityFinder;
    private final Readers weatherReader;
    private final WeatherModelList weatherModelList;

    public WeatherService(JsonCityFinder jsonCityFinder, Readers weatherReader, WeatherModelList weatherModelList) {
        this.jsonCityFinder = jsonCityFinder;
        this.weatherReader = weatherReader;
        this.weatherModelList = weatherModelList;
    }

    public List<WeatherModel> getWeatherInfo(String location) throws IOException {

        List<String> localization = jsonCityFinder.findLocation(location);
        String lon = localization.get(1);
        String lat = localization.get(0);
        Reader reader = weatherReader.getReaderForWeather(lon, lat);

        return weatherModelList.getWeatherModelList(reader);
    }




}
