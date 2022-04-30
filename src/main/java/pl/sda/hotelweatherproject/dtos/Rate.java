
package pl.sda.hotelweatherproject.dtos;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "no",
    "effectiveDate",
    "mid"
})
@NoArgsConstructor
@Generated("jsonschema2pojo")
public class Rate {

    @JsonProperty("mid")
    private Double mid;



    @JsonProperty("mid")
    public Double getMid() {
        return mid;
    }


}
