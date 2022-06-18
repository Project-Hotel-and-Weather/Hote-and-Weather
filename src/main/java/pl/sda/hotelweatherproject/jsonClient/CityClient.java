package pl.sda.hotelweatherproject.jsonClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.response.WorldCities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityClient {
    public List<String> findLocation(String location, String coun) throws IOException {
        Double lat = 0.0;
        Double lang = 0.0;
        if (location.equals("London")){
            location = "Impalaland";
        }
        String capitalizeCity = WordUtils.capitalizeFully(location);
        String capitalizeCountry = coun.toUpperCase();

        ObjectMapper om = new ObjectMapper();
        String path = "src/main/resources/worldCities.json";
        File jsonFile = new File(path);
        WorldCities[] worldCities = om.readValue(jsonFile, WorldCities[].class);
        List<String> cityAscii = Arrays.stream(worldCities).map(WorldCities::getCityAscii).collect(Collectors.toList());
        List<Double> longitude = Arrays.stream(worldCities).map(WorldCities::getLng).collect(Collectors.toList());
        List<Double> latitude = Arrays.stream(worldCities).map(WorldCities::getLat).collect(Collectors.toList());
        List<String> iso2 = Arrays.stream(worldCities).map(x -> x.getIso2()).collect(Collectors.toList());
        for (int j = 0; j < cityAscii.size(); j++) {
            if (capitalizeCity.equals(cityAscii.get(j)) && capitalizeCountry.equals(iso2.get(j))) {
                lat = longitude.get(j);
                lang = latitude.get(j);
                break;
            }
        }
        List<String> parameters = new ArrayList<>();
        parameters.add(String.valueOf(lang));
        parameters.add(String.valueOf(lat));
        return parameters;
    }
}
