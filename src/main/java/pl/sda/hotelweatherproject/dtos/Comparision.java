package pl.sda.hotelweatherproject.dtos;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Comparision {

    @SerializedName("Comparison")
    @Expose
    private List<List<HotelName>> comparison = new ArrayList<List<HotelName>>();


    public List<List<HotelName>> getComparison() {
        return comparison;
    }

    public void setComparison(List<List<HotelName>> comparison) {
        this.comparison = comparison;
    }
}

