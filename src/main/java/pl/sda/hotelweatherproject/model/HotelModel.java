package pl.sda.hotelweatherproject.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class HotelModel {
    String name;
    Double price;
    String line1;
    String city;
    String countryName;
    List<String> formatted;
    String roomName;
    String roomDescription;
    List<String> url;

}
