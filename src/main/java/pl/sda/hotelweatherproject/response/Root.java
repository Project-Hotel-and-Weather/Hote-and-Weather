package pl.sda.hotelweatherproject.response;

import pl.sda.hotelweatherproject.response.Main;
import pl.sda.hotelweatherproject.response.Weather;

import java.util.ArrayList;

public class Root{

    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public int dt;
    public int timezone;
    public int id;
    public String name;
    public int cod;
}
