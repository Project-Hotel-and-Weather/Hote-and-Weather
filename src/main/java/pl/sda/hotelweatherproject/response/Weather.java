package pl.sda.hotelweatherproject.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}
