package pl.sda.hotelweatherproject.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class ResponseWeather {

    @SerializedName("exampleWeather")
    @Expose
    private List<ExampleWeather> exampleWeatherList = null;

    public List<ExampleWeather> getExampleWeatherList() {
        return exampleWeatherList;
    }

    public void setExampleWeatherList(List<ExampleWeather> exampleWeatherList) {
        this.exampleWeatherList = exampleWeatherList;
    }
}
