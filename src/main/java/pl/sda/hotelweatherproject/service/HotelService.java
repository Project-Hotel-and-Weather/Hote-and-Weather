package pl.sda.hotelweatherproject.service;

import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.jsonClient.JsonCityFinder;
import pl.sda.hotelweatherproject.mock.HotelMock;
import pl.sda.hotelweatherproject.model.HotelModel;
import pl.sda.hotelweatherproject.modellist.HotelModelList;

import java.util.*;

@Service
public class HotelService {

    private final JsonCityFinder jsonCityFinder;

    private final HotelMock hotelMock;

    private final HotelModelList hotelModelList;

    public HotelService(JsonCityFinder jsonCityFinder, HotelMock hotelMock, HotelModelList hotelModelList) {
        this.jsonCityFinder = jsonCityFinder;
        this.hotelMock = hotelMock;
        this.hotelModelList = hotelModelList;
    }

    public List<HotelModel> getHotelInfo(String location) throws Exception {
        List<String> localization = jsonCityFinder.findLocation(location);
        List<HotelModel> hotelsList = new ArrayList<>();
        if (localization.isEmpty()) {
            hotelsList.add(null);
            return hotelsList;
        }
        String lat = localization.get(1);
        String lon = localization.get(0);

        String position = lat + "," + lon;
        List<HotelModel> hotelMockModel = hotelMock.getHotelMockModel(hotelsList, position);
        if (!(hotelModelList.getReaderForHotel(hotelsList, lon, lat).isEmpty())) {
            hotelModelList.getReaderForHotel(hotelsList, lon, lat);
        } else {
            return hotelMockModel;
        }
        return hotelsList;
    }


}
