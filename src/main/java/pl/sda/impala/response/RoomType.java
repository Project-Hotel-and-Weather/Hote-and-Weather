package pl.sda.impala.response;

import java.util.ArrayList;

public class RoomType {
    public String roomTypeId;
    public String name;
    public String description;
    public int maxOccupancy;
    public ArrayList<Rate> rates;
    public ArrayList<Amenity> amenities;
    public ArrayList<Image> images;
}
