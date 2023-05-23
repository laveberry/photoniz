package com.laveberry.photoniz.sample.controller;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("컨트롤러 테스트 샘플")
public class ControllerTest extends BaseSpringBootTest {


    @Test
    @Disabled
    void 컨트롤러() throws Exception {

        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
