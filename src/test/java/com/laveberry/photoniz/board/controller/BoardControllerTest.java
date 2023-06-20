package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("게시판 테스트")
class BoardControllerTest extends BaseSpringBootTest {

    @Test
    @Disabled //FIXME 토큰을 포함하는 요청을 보내도록 테스트 수정
    void BoardListTest() throws Exception {
        mockMvc.perform(get("/v1/board/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
