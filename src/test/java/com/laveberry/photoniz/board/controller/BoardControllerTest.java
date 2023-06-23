package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.user.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("게시판 테스트")
class BoardControllerTest extends BaseSpringBootTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private static final String AUTHORIZATION = "Authorization";
    private static final String NORMAL_TYPE = BoardType.NORMAL.getType();
    private static String token;

    @BeforeEach
    void generateToken() {
        token = jwtTokenProvider.createToken("test@test.com", Role.USER.getName());
    }


    @Test
    @DisplayName("게시판 리스트 요청")
    void boardListTest() throws Exception {
        //given

        //when

        //then
        mockMvc.perform(get("/v1/board/list?type={type}", NORMAL_TYPE)
                        .header(HttpHeaders.AUTHORIZATION, token)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("게시물 생성")
    void createBoard() throws Exception {

        //given
        CreateBoardModel createBoardModel = new CreateBoardModel("new_title", "new_content", NORMAL_TYPE);

        //when
        //then
        mockMvc.perform(post("/v1/board")
                .header(HttpHeaders.AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createBoardModel)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
