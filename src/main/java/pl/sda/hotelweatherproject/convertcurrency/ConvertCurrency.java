package pl.sda.hotelweatherproject.convertcurrency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.sda.hotelweatherproject.response.currencyexchangeresponse.Example;
import pl.sda.hotelweatherproject.webclient.ExchangeClient;
@Component
public class ConvertCurrency {

    private final ExchangeClient exchangeClient;

    public ConvertCurrency(ExchangeClient exchangeClient) {
        this.exchangeClient = exchangeClient;
    }

    public Double getConvertCurrency(String code, Double amount) throws JsonProcessingException {
        String response = exchangeClient.getExchangeForCurrency(code);
        ObjectMapper mapper = new ObjectMapper();
        Example example = mapper.readValue(response, Example.class);
        Double mid = example.getRates().get(0).getMid();
        return (int) Math.round((amount / mid) * 100) / 100.00;
    }
}
