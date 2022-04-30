package pl.sda.hotelweatherproject.service;

import ch.qos.logback.core.joran.event.BodyEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.webclient.Main;
import pl.sda.hotelweatherproject.webclient.WeatherClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.reflect.*;

@Service
public class WeatherService {

    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>(){}.getType());
        return map;
    }

    public String getWeatherInfo() throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=41.87&lon=-87.62&appid=2d75c857e890f7742729cf3b29c7631f&units=metric");
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
        Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());


        return respMap.get("name")+ " " + mainMap.get("temp").toString() + "°C";
    }
}
