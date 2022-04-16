package com.jiadi.rest.Controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class JukeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getJukeBySettingId() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jukes/settingid/9ac2d388-0f1b-4137-8415-02b953dd76f7");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("[{\"id\":\"5ca94a8acfdeb5e01e5bdbe8\",\"model\":\"virtuo\",\"components\":[{\"name\":\"money_storage\"},{\"name\":\"money_pcb\"},{\"name\":\"money_storage\"},{\"name\":\"camera\"},{\"name\":\"money_receiver\"}]}]",result.getResponse().getContentAsString());
    }

    @Test
    void getJukeByModel() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jukes/model/fusion");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("{\"id\":\"5ca94a8ac470d3e47cd4713c\",\"model\":\"fusion\",\"components\":[{\"name\":\"led_panel\"},{\"name\":\"amplifier\"},{\"name\":\"led_panel\"},{\"name\":\"led_panel\"},{\"name\":\"pcb\"}]}",result.getResponse().getContentAsString());
    }

    @Test
    void getJukesOffsetLimit() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jukes/12/2");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("[{\"id\":\"5ca94a8a4aeb7ab33a5e1047\",\"model\":\"virtuo\",\"components\":[{\"name\":\"money_pcb\"},{\"name\":\"camera\"}]},{\"id\":\"5ca94a8ad2d584257d25ae50\",\"model\":\"fusion\",\"components\":[{\"name\":\"money_receiver\"},{\"name\":\"money_receiver\"},{\"name\":\"money_pcb\"},{\"name\":\"amplifier\"},{\"name\":\"led_panel\"}]}]",result.getResponse().getContentAsString());
    }

    @Test
    void getSettingById() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/settings/id/e9869bbe-887f-4d0a-bb9d-b81eb55fbf0a");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("{\"id\":\"e9869bbe-887f-4d0a-bb9d-b81eb55fbf0a\",\"requires\":[\"camera\",\"speaker\",\"pcb\"]}",result.getResponse().getContentAsString());
    }
}