package pl.sda.hotelweatherproject.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.response.worldcityresponse.WorldCities;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class Readers {

    public WorldCities[] getReaderForWorldCity() throws IOException {
        ObjectMapper om = new ObjectMapper();
        String path = "src/main/resources/worldCities.json";
        File jsonFile = new File(path);
        WorldCities[] worldCities = om.readValue(jsonFile, WorldCities[].class);
        return worldCities;
    }

    public Reader getReaderForWeather(String lon, String lat) throws IOException {
        String url = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=hourly,minutely,alerts&appid=2d75c857e890f7742729cf3b29c7631f&units=metric&lang=en";
        InputStream is = new URL(url).openStream();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        return reader;
    }


}
