
package pl.sda.hotelweatherproject.response.hotelimpalaresponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class TaxesAndFees {

    @SerializedName("includedInRate")
    @Expose
    private List<Object> includedInRate = null;
    @SerializedName("payAtHotel")
    @Expose
    private List<Object> payAtHotel = null;

    public List<Object> getIncludedInRate() {
        return includedInRate;
    }

    public void setIncludedInRate(List<Object> includedInRate) {
        this.includedInRate = includedInRate;
    }

    public List<Object> getPayAtHotel() {
        return payAtHotel;
    }

    public void setPayAtHotel(List<Object> payAtHotel) {
        this.payAtHotel = payAtHotel;
    }

}
