package com.laveberry.photoniz.sample.controller;

import com.laveberry.photoniz.sample.BaseSpringBootTest;
import org.junit.jupiter.api.Test;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest extends BaseSpringBootTest {


    @Test
    void 컨트롤러() throws Exception {

        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
