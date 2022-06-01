package pl.sda.hotelweatherproject.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Weather {

    double temp;
    String name;
    String result;

}
