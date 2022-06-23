package pl.sda.hotelweatherproject.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
public class WeatherModel {

    private String date;
    private String dayOfTheWeek;
    private String sunRise;
    private String sunSet;
    private Integer tempDay;
    private Integer tempNight;
    private String main;
    private Integer humidity;

}
