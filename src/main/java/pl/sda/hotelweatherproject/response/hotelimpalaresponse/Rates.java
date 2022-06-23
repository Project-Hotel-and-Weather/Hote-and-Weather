
package pl.sda.hotelweatherproject.response.hotelimpalaresponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Rates {

    @SerializedName("rateId")
    @Expose
    private String rateId;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("maxOccupancy")
    @Expose
    private Integer maxOccupancy;
    @SerializedName("hotelAgreement")
    @Expose
    private Object hotelAgreement;
    @SerializedName("retailRate")
    @Expose
    private RetailRate retailRate;
    @SerializedName("sellerCommissionPercentage")
    @Expose
    private Integer sellerCommissionPercentage;
    @SerializedName("components")
    @Expose
    private List<Object> components = null;
    @SerializedName("cancellationPolicies")
    @Expose
    private List<CancellationPolicy> cancellationPolicies = null;

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Object getHotelAgreement() {
        return hotelAgreement;
    }

    public void setHotelAgreement(Object hotelAgreement) {
        this.hotelAgreement = hotelAgreement;
    }

    public RetailRate getRetailRate() {
        return retailRate;
    }

    public void setRetailRate(RetailRate retailRate) {
        this.retailRate = retailRate;
    }

    public Integer getSellerCommissionPercentage() {
        return sellerCommissionPercentage;
    }

    public void setSellerCommissionPercentage(Integer sellerCommissionPercentage) {
        this.sellerCommissionPercentage = sellerCommissionPercentage;
    }

    public List<Object> getComponents() {
        return components;
    }

    public void setComponents(List<Object> components) {
        this.components = components;
    }

    public List<CancellationPolicy> getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(List<CancellationPolicy> cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }

}
