package pl.sda.hotelweatherproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.sda.hotelweatherproject.repository.CityRepository;

@SpringBootApplication
public class HotelWeatherProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelWeatherProjectApplication.class, args);
    }

}
