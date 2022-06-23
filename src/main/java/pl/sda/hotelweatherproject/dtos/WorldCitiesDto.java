package pl.sda.hotelweatherproject.dtos;

import javax.persistence.*;

@Entity
@Table(name = "world_cities")
public class WorldCitiesDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private Double latitude;
    private Double longitude;
    private String iso2;

    public WorldCitiesDto(){

    }
    public WorldCitiesDto(Long id, String city, Double latitude, Double longitude, String iso2) {
        this.id = id;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.iso2 = iso2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
