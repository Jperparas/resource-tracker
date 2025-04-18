package io.github.jperparas.resourcetrackerpwa.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.services.SpotService;
import io.github.jperparas.resourcetrackerpwa.services.SpotServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SpotController.class)
class SpotControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    SpotService spotService;

    SpotServiceImpl spotServiceImpl;

    @Captor
    ArgumentCaptor<SpotDTO> spotArgumentCaptor;

    @Captor
    ArgumentCaptor<Integer> spotIdCaptor;

    @BeforeEach
    void setUp() {
        
    }


    @Test
    void listSpots() {
    }

    @Test
    void listSpotsWithTimeStamp() {
    }

    @Test
    void getSpotById() {
    }

    @Test
    void getGpuCountBySpotId() {
    }

    @Test
    void getLastVisitedTimeById() {
    }
}