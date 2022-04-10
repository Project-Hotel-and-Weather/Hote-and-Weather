package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Example;
import pl.sda.hotelweatherproject.dtos.Rate;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;

import java.text.DecimalFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private Rate rate;
    private final ExchangeClient exchangeClient;

    public void getHotelInfo(String location, Date date){
        boolean isDatabaseExist = hotelRepository.getFromDatabase != null && hotelRepository.getFromDatabase.date == date;
        if(isDatabaseExist) {
            hotelRepository.getFromDataBase();
        } else {
            boolean isDifferentDate = hotelRepository.getFromDatabase.date != date;
            if(isDifferentDate){
                hotelRepository.updateInDataBase();
            } else {
                hotelRepository.createInDatabase();
            }
        }
    }

    public String convertUSDToPLN(double price) throws JsonProcessingException {
        final DecimalFormat df = new DecimalFormat("0.00");
        String response = exchangeClient.getExchangeForCurrency("USD");
        ObjectMapper objectMapper = new ObjectMapper();
        Example example = objectMapper.readValue(response, Example.class);
        Double mid = example.getRates().get(0).getMid();
        double finalPrice = price * mid;
        return df.format(finalPrice);
    }

}
