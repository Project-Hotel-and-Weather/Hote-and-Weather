package pl.sda.hotelweatherproject.response.worldcityresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import pl.sda.hotelweatherproject.response.worldcityresponse.WorldCities;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
@Getter
@Setter
public class Started {

    @SerializedName("worldCities")
    @Expose
    private List<WorldCities> worldCities = null;

    public List<WorldCities> getWorldCities() {
        return worldCities;
    }

    public void setCities(List<WorldCities> worldCities) {
        this.worldCities = worldCities;
    }
}
