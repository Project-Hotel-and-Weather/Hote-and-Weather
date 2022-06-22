package pl.sda.hotelweatherproject.jsonClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.WordUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.configuration.HibernateConfiguration;
import pl.sda.hotelweatherproject.dtos.WorldCitiesDto;
import pl.sda.hotelweatherproject.response.WorldCities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityClient {

@Transac
    public List<String> findLocation(String location) throws IOException {

        double lat;
        double lang;
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String capitalizeCity = WordUtils.capitalizeFully(location);
        capitalizeCity.replaceAll("\\+", " ");
        List<String> parameters = new ArrayList<>();

        Object uniqueResult = session.createQuery("SELECT w.city from WorldCitiesDto as w where w.city = :location").setParameter("location", capitalizeCity).uniqueResult();
        if (uniqueResult == null) {
            ObjectMapper om = new ObjectMapper();
            String path = "src/main/resources/worldCities.json";
            File jsonFile = new File(path);
            WorldCities[] worldCities = om.readValue(jsonFile, WorldCities[].class);
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
            transaction.commit();
            session.close();
        } else {
            List<Object> resultList = session.createQuery("SELECT w.city, w.longitude, w.latitude from WorldCitiesDto as w where w.city = :location").setParameter("location", capitalizeCity).getResultList();
            for (Object o : resultList) {
                Object[] objects = (Object[]) o;
                lang = (Double) objects[2];
                lat = (Double) objects[1];
                parameters.add(String.valueOf(lang));
                parameters.add(String.valueOf(lat));
            }
        }
        session.close();

        return parameters;
    }
}
