package pl.sda.hotelweatherproject.jsonClient;

import org.apache.commons.text.WordUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.configur.HibernateConfiguration;
import pl.sda.hotelweatherproject.dtos.WorldCitiesDto;
import pl.sda.hotelweatherproject.readers.Readers;
import pl.sda.hotelweatherproject.repository.CityRepository;
import pl.sda.hotelweatherproject.response.worldcityresponse.WorldCities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonCityFinder {

    private final Readers readers;
    private final CityRepository cityRepository;

    public JsonCityFinder(Readers readers, CityRepository cityRepository) {
        this.readers = readers;
        this.cityRepository = cityRepository;
    }

    public List<String> findLocation(String location) throws IOException {

        double lat;
        double lang;
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String capitalizeCity = WordUtils.capitalizeFully(location);
        capitalizeCity.replaceAll("\\+", " ");
        List<String> parameters = new ArrayList<>();

        List<WorldCitiesDto> byCity = cityRepository.findByCity(capitalizeCity);
        if (byCity.size() == 0) {
            WorldCities[] worldCities = readers.getReaderForWorldCity();
            List<String> cityAscii = Arrays.stream(worldCities).map(WorldCities::getCityAscii).collect(Collectors.toList());
            List<Double> longitude = Arrays.stream(worldCities).map(WorldCities::getLng).collect(Collectors.toList());
            List<Double> latitude = Arrays.stream(worldCities).map(WorldCities::getLat).collect(Collectors.toList());
            List<String> iso2 = Arrays.stream(worldCities).map(WorldCities::getIso2).collect(Collectors.toList());

            WorldCitiesDto worldCitiesDto = new WorldCitiesDto();

            for (int j = 0; j < cityAscii.size(); j++) {
                if (capitalizeCity.equals(cityAscii.get(j))) {
                    lat = longitude.get(j);
                    lang = latitude.get(j);
                    worldCitiesDto.setCity(cityAscii.get(j));
                    worldCitiesDto.setLongitude(longitude.get(j));
                    worldCitiesDto.setLatitude(latitude.get(j));
                    worldCitiesDto.setIso2(iso2.get(j));
                    session.save(worldCitiesDto);
                    parameters.add(String.valueOf(lang));
                    parameters.add(String.valueOf(lat));
                    break;
                }

            }
        } else {
            Double longitude = byCity.stream().map(WorldCitiesDto::getLongitude).collect(Collectors.averagingDouble(Double::doubleValue));
            Double latitude = byCity.stream().map(WorldCitiesDto::getLatitude).collect(Collectors.averagingDouble(Double::doubleValue));
            parameters.add(String.valueOf(longitude));
            parameters.add(String.valueOf(latitude));
        }

        transaction.commit();
        session.close();

        return parameters;
    }


}
