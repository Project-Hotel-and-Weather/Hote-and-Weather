
package pl.sda.hotelweatherproject.response.hotelimpalaresponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("hotelId")
    @Expose
    private String hotelId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("starRating")
    @Expose
    private Integer starRating;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("externalUrls")
    @Expose
    private List<ExternalUrl> externalUrls = null;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("websiteUrl")
    @Expose
    private String websiteUrl;
    @SerializedName("phoneNumbers")
    @Expose
    private List<String> phoneNumbers = null;
    @SerializedName("contractable")
    @Expose
    private Boolean contractable;
    @SerializedName("emails")
    @Expose
    private List<String> emails = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("amenities")
    @Expose
    private List<Amenity> amenities = null;
    @SerializedName("roomTypes")
    @Expose
    private List<RoomType> roomTypes = null;
    @SerializedName("roomCount")
    @Expose
    private Integer roomCount;
    @SerializedName("checkIn")
    @Expose
    private CheckIn checkIn;
    @SerializedName("checkOut")
    @Expose
    private CheckOut checkOut;
    @SerializedName("termsAndConditions")
    @Expose
    private String termsAndConditions;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<ExternalUrl> getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(List<ExternalUrl> externalUrls) {
        this.externalUrls = externalUrls;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Boolean getContractable() {
        return contractable;
    }

    public void setContractable(Boolean contractable) {
        this.contractable = contractable;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
