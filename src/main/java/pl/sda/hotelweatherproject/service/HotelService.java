package pl.sda.hotelweatherproject.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HotelService {

    public void getHotelInfo(String location, Date date){
        boolean isDatabaseExist = getFromDatabase != null && getFromDatabase.date == date;
        if(isDatabaseExist) {
            getFromDataBase();
        } else {
            boolean isDifferentDate = getFromDatabase.date != date;
            if(isDifferentDate){
                updateInDataBase();
            } else {
                createInDatabase();
            }
        }
    }

}
