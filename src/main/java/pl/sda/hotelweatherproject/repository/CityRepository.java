package pl.sda.hotelweatherproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.hotelweatherproject.dtos.WorldCitiesDto;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<WorldCitiesDto, Serializable> {

    List<WorldCitiesDto> findByCity(String city);

}
