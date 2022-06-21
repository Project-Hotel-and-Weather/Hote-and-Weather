
package pl.sda.hotelweatherproject.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BusinessesAtLocation {

    @SerializedName("businessAddress")
    @Expose
    private BusinessAddress businessAddress;
    @SerializedName("businessInfo")
    @Expose
    private BusinessInfo businessInfo;

    public BusinessAddress getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(BusinessAddress businessAddress) {
        this.businessAddress = businessAddress;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }

}
