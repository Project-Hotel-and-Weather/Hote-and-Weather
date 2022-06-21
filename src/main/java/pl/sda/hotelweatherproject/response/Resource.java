
package pl.sda.hotelweatherproject.response;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Resource {

    @SerializedName("__type")
    @Expose
    private String type;
    @SerializedName("isPrivateResidence")
    @Expose
    private String isPrivateResidence;
    @SerializedName("businessesAtLocation")
    @Expose
    private List<BusinessesAtLocation> businessesAtLocation = null;
    @SerializedName("naturalPOIAtLocation")
    @Expose
    private List<Object> naturalPOIAtLocation = null;
    @SerializedName("addressOfLocation")
    @Expose
    private List<Object> addressOfLocation = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsPrivateResidence() {
        return isPrivateResidence;
    }

    public void setIsPrivateResidence(String isPrivateResidence) {
        this.isPrivateResidence = isPrivateResidence;
    }

    public List<BusinessesAtLocation> getBusinessesAtLocation() {
        return businessesAtLocation;
    }

    public void setBusinessesAtLocation(List<BusinessesAtLocation> businessesAtLocation) {
        this.businessesAtLocation = businessesAtLocation;
    }

    public List<Object> getNaturalPOIAtLocation() {
        return naturalPOIAtLocation;
    }

    public void setNaturalPOIAtLocation(List<Object> naturalPOIAtLocation) {
        this.naturalPOIAtLocation = naturalPOIAtLocation;
    }

    public List<Object> getAddressOfLocation() {
        return addressOfLocation;
    }

    public void setAddressOfLocation(List<Object> addressOfLocation) {
        this.addressOfLocation = addressOfLocation;
    }

}
