package pl.sda.hotelweatherproject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HotelWeatherProjectApplicationTestsModel {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnAnEmptyPageWithError404() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is(404));
    }

    @Test
    void findAHotelForCityThatExists() throws Exception {
        mockMvc.perform(get("/hotel")
                        .param("location", "barcelona")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void notFindAHotelThatExistsAndReturnNull() throws Exception {
        mockMvc.perform(get("/hotel")
                .param("location","Vladywostok")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.concat(null)").value(""));
    }

    @Test
    void findAWeatherForCityThatExists() throws Exception {
        mockMvc.perform(get("/weather")
                        .param("location", "barcelona")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Sant Pere, Santa Caterina i La Ribera"));
    }

    @Test
    void notFindAWeatherThatExistsAndReturnNull() throws Exception {
        mockMvc.perform(get("/hotel")
                        .param("location","Vladywostok")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.concat(null)").value(""));
    }



}
