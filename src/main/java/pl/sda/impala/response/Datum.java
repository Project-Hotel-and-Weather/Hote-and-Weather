package pl.sda.impala.response;

import java.util.ArrayList;
import java.util.Date;

public class Datum {
    public String hotelId;
    public String name;
    public int starRating;
    public Description description;
    public ArrayList<ExternalUrl> externalUrls;
    public String currency;
    public String websiteUrl;
    public ArrayList<String> phoneNumbers;
    public boolean contractable;
    public ArrayList<String> emails;
    public ArrayList<Image> images;
    public Address address;
    public Location location;
    public ArrayList<Amenity> amenities;
    public ArrayList<RoomType> roomTypes;
    public int roomCount;
    public CheckIn checkIn;
    public CheckOut checkOut;
    public String termsAndConditions;
    public Date createdAt;
    public Date updatedAt;
}
