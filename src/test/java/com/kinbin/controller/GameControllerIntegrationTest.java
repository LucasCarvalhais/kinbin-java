package com.kinbin.controller;

import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.model.kinbin.KinbinImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldShowKinbinStatus() throws Exception {
        Kinbin kinbin = new KinbinImpl();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Name:")))
                .andExpect(content().string(containsString("Status:")))
                .andExpect(content().string(containsString("Age:")))
                .andExpect(content().string(containsString("Mood:")))
                .andExpect(content().string(containsString("Weight:")))
                .andExpect(content().string(containsString("Energy:")))
                .andExpect(content().string(containsString("Fortune:")));
    }

    @Test
    public void shouldPulse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pulse"))
                .andExpect(status().isFound());
    }

}
