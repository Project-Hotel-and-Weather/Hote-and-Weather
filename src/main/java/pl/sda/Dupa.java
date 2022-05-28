package pl.sda;

import pl.sda.hotelweatherproject.service.HotelService;

import java.io.IOException;

public class Dupa {

    public static void main(String[] args) {
        HotelService hs = new HotelService(null);

        try {
            hs.getHotelInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
