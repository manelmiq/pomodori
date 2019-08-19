package com.pomodori.pomodori.data.webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pomodori.pomodori.PomodoriApplication;
import com.pomodori.pomodori.data.entity.Pomodori;
import com.pomodori.pomodori.data.repository.PomodoriRepository;
import org.hamcrest.Matchers;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static com.pomodori.pomodori.data.webservices.PomodoriController.POMODORI_END_POINT;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PomodoriControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PomodoriRepository pomodoriRepository;


    @Test
    public void getAllPomodoro() throws Exception {
        mockMvc.perform(
                get("/" + POMODORI_END_POINT)
                        .accept("application/json")
        ).andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }


    @Test
    public void getPomodoro() throws Exception {
        Calendar c = Calendar.getInstance();
        Date begin = new Date();
        Date end = new Date();
        Date rest = new Date();
        Pomodori pomodori = new Pomodori(10, "test", begin, end, rest);
        pomodori.setId(1);
        mockMvc.perform(get("/" + POMODORI_END_POINT + "/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))

                .andDo(print());
//                .andReturn().getResponse().getContentAsString();


//                .andExpect(jsonPath("$.data.description", Matchers.is("test")));
//        Mockito.verify(pomodoriRepository).findById(1);

    }

//    @Test
//    public void addItem() throws Exception {
//        String jsonString = "{\n" +
//                "\"id\":1,\n" +
//                "\"name\":\"iPhoneX\",\n" +
//                "\"category\":\"Mobiles\"\n" +
//                "}";
//        AbstractReadWriteAccess.Item item = new AbstractReadWriteAccess.Item(1,"iPhoneX","Mobiles");
//        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("iPhoneX")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.category",Matchers.is("Mobiles")));
//    }

//    @Test
//    public void updateItem() throws Exception {
//        String jsonString = "{\n" +
//                "\"id\":1,\n" +
//                "\"name\":\"iPhoneX\",\n" +
//                "\"category\":\"Mobiles\"\n" +
//                "}";
//        Pomodori item = new Pomodori(1,"iPhoneX","Mobiles");
//        mockMvc.perform(MockMvcRequestBuilders.put("/updateItem")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("iPhoneX")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.category",Matchers.is("Mobiles")));
//    }
//
//    @Test
//    public void deleteItem() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isAccepted());
//    }
}
