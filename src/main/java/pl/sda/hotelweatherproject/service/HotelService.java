package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Comparison;
import pl.sda.hotelweatherproject.dtos.Example;
import pl.sda.hotelweatherproject.repository.HotelRepository;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;
import pl.sda.hotelweatherproject.webclient.HotelClient;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HotelService {


    private final HotelClient hotelClient;

    public String getHotelInfo() {
//        boolean isThatSameDate = hotelRepository.getDateFromDataBase() == date;
//        boolean isDatabaseExist = hotelRepository.getFromDataBase() != null && isThatSameDate;
//        if (isDatabaseExist) {
//            hotelRepository.getFromDataBase();
//        } else {
//            boolean isDifferentDate = !isThatSameDate;
//            if (isDifferentDate) {
//                hotelRepository.updateInDataBase();
//            } else {
//                hotelRepository.createInDatabase();
//            }
//        }
        return "Chicago";
    }


}
