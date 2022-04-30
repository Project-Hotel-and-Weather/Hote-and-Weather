package pl.sda.hotelweatherproject.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeClient {
     private static final String EXCHANGE_URL = "https://api.nbp.pl/api/exchangerates/rates/";
     private RestTemplate restTemplate = new RestTemplate();

     public String getExchangeForCurrency(String code){
         String codeUSD = "USD";
         return restTemplate.getForObject(EXCHANGE_URL + "{table}/{code}/?format=json", String.class,"A", codeUSD);
     }
}
