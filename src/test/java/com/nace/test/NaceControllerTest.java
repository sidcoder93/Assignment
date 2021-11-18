package com.nace.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nace.controller.NaceController;
import com.nace.entity.Nace;
import com.nace.service.NaceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class NaceControllerTest {

    @Mock
    NaceService naceService;
    private Nace nace;

    @InjectMocks
    private NaceController naceController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {

        nace = Nace.builder()
                .orderNo(398481L)
                .level(1)
                .code("A")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .thisItemIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.")
                .ref("A").build();

      mockMvc = MockMvcBuilders.standaloneSetup(naceController).build();

    }

    @AfterEach
    void tearDown() {
        nace = null;
    }

    @Test
    public void PostMappingTestOfNaceController() throws Exception{

        when(naceService.saveNaceDetails(any())).thenReturn(nace);
        mockMvc.perform(post("/details/").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(nace))).
                andExpect(status().isCreated());
        verify(naceService,times(1)).saveNaceDetails(any());
    }

    @Test
    public void GetMappingTestOfNaceController() throws Exception {
        when(naceService.getNaceDetails(nace.getOrderNo())).thenReturn(nace);
        mockMvc.perform(get("/details/398481").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(nace))).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

}
}

