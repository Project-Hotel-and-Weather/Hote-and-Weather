package pl.sda.hotelweatherproject.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class HotelClient {

    private final String secretHotel = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDk1ODMyNzEsImlhdCI6MTY0OTU4MTQ3MSwibmJmIjoxNjQ5NTgxNDcxLCJpZGVudGl0eSI6MTIxNn0.rku-Vy1EpXktGJlNT7XPfrVGTFunCZIdSoF8GTncco4";
    private RestTemplate restTemplate = new RestTemplate();
    private final String HOTEL_URL = "https://api.makcorps.com/free";

    public String getHotel(String location){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", secretHotel);
        return restTemplate.getForObject(HOTEL_URL + "/{location}", String.class, location);
    }
}
