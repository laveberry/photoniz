package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.work.enums.WorkType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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
    private static final String MAIN_TYPE = MainType.AUTHOR.getType();
    private static final String WORK_TYPE = WorkType.BODY.getValue();


    @Test
    @DisplayName("게시판 리스트 요청")
    void boardListTest() throws Exception {
        //given

        //when

        //then
        mockMvc.perform(get("/v1/board/list?type={type}&mainType={mainType}", NORMAL_TYPE, MAIN_TYPE)
                        .header(HttpHeaders.AUTHORIZATION, token)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Disabled
    @DisplayName("게시물 생성")
    void createBoard() throws Exception {

        //given
        CreateBoardModel createBoardModel = new CreateBoardModel("new_title", "new_content", NORMAL_TYPE, MAIN_TYPE, WORK_TYPE);

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
