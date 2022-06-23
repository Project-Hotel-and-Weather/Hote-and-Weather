package pl.sda.hotelweatherproject.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.jsonClient.CityClient;
import pl.sda.hotelweatherproject.model.WeatherModel;
import pl.sda.hotelweatherproject.response.Daily;
import pl.sda.hotelweatherproject.response.ExampleWeather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class WeatherService {

    private final CityClient cityClient;

    public WeatherService(CityClient cityClient) {
        this.cityClient = cityClient;
    }

    public List<WeatherModel> getWeatherInfo(String location) throws IOException, ParseException {

        List<String> localization = cityClient.findLocation(location);
        String lon = localization.get(1);
        String lat = localization.get(0);
        String url = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=hourly,minutely,alerts&appid=2d75c857e890f7742729cf3b29c7631f&units=metric&lang=en";
        InputStream is = new URL(url).openStream();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        ExampleWeather exampleWeather = gson.fromJson(reader, ExampleWeather.class);

        SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dayOfTheWeek = new SimpleDateFormat("EEEE");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");

        List<WeatherModel> weatherModelList = new ArrayList<>();
        String timezone = exampleWeather.getTimezone();
        ZoneId of = ZoneId.of(timezone);
        time.setTimeZone(TimeZone.getTimeZone(of));
        for (Daily daily : exampleWeather.getDaily()) {
            int dt = daily.getDt();
            Integer sunrise = daily.getSunrise();
            Integer sunset = daily.getSunset();
            Date timeStamp = new Date(dt * 1000L);
            Date sunriseTime = new Date(sunrise * 1000L);
            Date sunsetTime = new Date(sunset * 1000L);

            String dateParse = data.format(timeStamp);
            String dayOfTheWeekParse = dayOfTheWeek.format(timeStamp);
            String sunriseParse = time.format(sunriseTime);
            String sunsetParse = time.format(sunsetTime);
            Double day = daily.getTemp().getDay();
            Double night = daily.getTemp().getNight();
            Integer humidity = daily.getHumidity();
            for (int i = 0; i < daily.getWeather().size(); i++) {
                String main = daily.getWeather().get(i).getMain();
                weatherModelList.add(WeatherModel.builder()
                        .date(dateParse)
                        .dayOfTheWeek(dayOfTheWeekParse)
                        .sunRise(sunriseParse)
                        .sunSet(sunsetParse)
                        .tempDay(day.intValue())
                        .tempNight(night.intValue())
                        .humidity(humidity)
                        .main(main)
                        .build());
            }
        }
        return weatherModelList;
    }
}
