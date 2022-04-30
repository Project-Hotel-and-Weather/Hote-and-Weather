
package pl.sda.hotelweatherproject.dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "table",
    "currency",
    "code",
    "rates"
})
@Generated("jsonschema2pojo")
public class Example {


    @JsonProperty("rates")
    private List<Rate> rates = null;

    @JsonProperty("rates")
    public List<Rate> getRates() {
        return rates;
    }


}
