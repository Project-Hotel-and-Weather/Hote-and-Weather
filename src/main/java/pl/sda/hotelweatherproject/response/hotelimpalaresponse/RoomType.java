
package pl.sda.hotelweatherproject.response.hotelimpalaresponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RoomType {

    @SerializedName("roomTypeId")
    @Expose
    private String roomTypeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("maxOccupancy")
    @Expose
    private Integer maxOccupancy;
    @SerializedName("rates")
    @Expose
    private List<Rates> rates = null;
    @SerializedName("amenities")
    @Expose
    private List<Amenity__1> amenities = null;
    @SerializedName("images")
    @Expose
    private List<Image__1> images = null;

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }

    public List<Amenity__1> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity__1> amenities) {
        this.amenities = amenities;
    }

    public List<Image__1> getImages() {
        return images;
    }

    public void setImages(List<Image__1> images) {
        this.images = images;
    }

}
