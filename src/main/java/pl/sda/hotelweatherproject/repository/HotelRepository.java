//package pl.sda.hotelweatherproject.repository;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import pl.sda.hotelweatherproject.dtos.HotelName;
//import pl.sda.hotelweatherproject.dtos.Example;
//import pl.sda.hotelweatherproject.service.HotelService;
//import pl.sda.hotelweatherproject.webclient.ExchangeClient;
//
//import java.text.DecimalFormat;
//import java.util.Date;
//import java.util.Map;
//
//@Repository
//@RequiredArgsConstructor
//public class HotelRepository {
//
//    private final ExchangeClient exchangeClient;
//
//    private final HotelService hotelService;
//
//    public String getFromDataBase() {
//        String location;
//        double price;
//        try {
//            location = takePriceAndHotelName("Londyn");
//            price = Double.parseDouble(convertUSDToPLN(259.17));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return location + price;
//    }
//
//    public static Date getDateFromDataBase() {
//        Date date = new Date();
//        return date;
//    }
//
//    public static void updateInDataBase() {
//    }
//
//    public static void createInDatabase() {
//
//    }
//
//    public String convertUSDToPLN(double price) throws JsonProcessingException {
//        final DecimalFormat df = new DecimalFormat("0.00");
//
//        String response = exchangeClient.getExchangeForCurrency("USD");
//        ObjectMapper objectMapper = new ObjectMapper();
//        Example example = objectMapper.readValue(response, Example.class);
//        Double mid = example.getRates().get(0).getMid();
//        double finalPrice = price * mid;
//        return df.format(finalPrice);
//    }
//
////    public String takePriceAndHotelName(String location) throws JsonProcessingException {
//////        String response = "Chicago";
//////        ObjectMapper objectMapper = new ObjectMapper();
//////        HotelName comparison = objectMapper.readValue(response, HotelName.class);
//////        String hotelName = comparison.getHotelName();
//////        Map<String, Object> additionalProperties = comparison.getAdditionalProperties();
//////        return hotelName + additionalProperties.get(0);
////    }
//}
