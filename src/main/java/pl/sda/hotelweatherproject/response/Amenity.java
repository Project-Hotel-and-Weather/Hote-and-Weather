
package pl.sda.hotelweatherproject.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Amenity {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("formatted")
    @Expose
    private String formatted;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

}
