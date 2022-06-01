package pl.sda.hotelweatherproject.service;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Root;
import pl.sda.hotelweatherproject.dtos.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WeatherService {
    @Builder
    public pl.sda.hotelweatherproject.model.Weather getWeatherInfo() throws IOException {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=41.87&lon=41.87&appid=2d75c857e890f7742729cf3b29c7631f&units=metric&lang=pl";
        InputStream is = new URL(url).openStream();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        Root root = gson.fromJson(reader, Root.class);

        String description = "";
        for (Weather weather: root.weather) {
            description = weather.description;
        }

        UnaryOperator<String> capitalize = str -> str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
        String result = Stream.of(description.split(" "))
                .map(capitalize)
                .collect(Collectors.joining(" "));

        double temp = root.main.temp;
        String name = root.name;

        pl.sda.hotelweatherproject.model.Weather build = pl.sda.hotelweatherproject.model.Weather.builder()
                .result(result)
                .temp(temp)
                .name(name)
                .build();


        return build;
    }
}
