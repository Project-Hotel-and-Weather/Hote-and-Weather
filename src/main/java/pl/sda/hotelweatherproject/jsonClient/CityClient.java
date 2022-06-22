package pl.sda.hotelweatherproject.jsonClient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.dtos.WorldCitiesDto;
import pl.sda.hotelweatherproject.response.WorldCities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityClient {
    public List<String> findLocation(String location) throws IOException {

        Double lat = 0.0;
        Double lang = 0.0;
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        configuration.addAnnotatedClass(WorldCitiesDto.class);
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        String capitalizeCity = WordUtils.capitalizeFully(location);
        Object uniqueResult = currentSession.createQuery("SELECT w.city from WorldCitiesDto as w where w.city = :location").setParameter("location", capitalizeCity).uniqueResult();
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
                    break;
                }
            }
            currentSession.save(worldCitiesDto);
            currentSession.getTransaction().commit();
            sessionFactory.close();
        } else {
            List<Object> resultList = currentSession.createQuery("SELECT w.city, w.longitude, w.latitude from WorldCitiesDto as w where w.city = :location").setParameter("location", capitalizeCity).getResultList();
            for (Iterator<Object> it = resultList.iterator(); it.hasNext();) {
                Object[] objects = (Object[]) it.next();
                lang = (Double) objects[2];
                lat = (Double) objects[1];
            }
        }
        List<String> parameters = new ArrayList<>();
        parameters.add(String.valueOf(lang));
        parameters.add(String.valueOf(lat));

        return parameters;
    }
}
