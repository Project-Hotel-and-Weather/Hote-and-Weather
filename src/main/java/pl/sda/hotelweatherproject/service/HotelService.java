package pl.sda.hotelweatherproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;
import pl.sda.hotelweatherproject.dtos.Comparision;
import pl.sda.hotelweatherproject.webclient.HotelClient;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelClient hotelClient;

    public String getHotelInfo() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        String path = "C:\\Users\\Hyperbook\\Desktop\\response.json";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//        Gson gson = new Gson();
        FileReader fileReader = new FileReader(path);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            parserObject(object);
        }



        return "";
    }


    private static void parserObject(JSONObject object){
        String hotelName = (String) object.get("hotelName");
        String price = (String) object.get("price1");
        String tax = (String) object.get("tax1");
    }


}
