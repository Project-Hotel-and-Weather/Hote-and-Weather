
package pl.sda.hotelweatherproject.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CancellationPolicy {

    @SerializedName("formatted")
    @Expose
    private String formatted;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("fee")
    @Expose
    private Fee fee;
    @SerializedName("end")
    @Expose
    private String end;

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
