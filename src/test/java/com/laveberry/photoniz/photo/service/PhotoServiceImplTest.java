package com.laveberry.photoniz.photo.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.service.BoardService;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.work.enums.WorkType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;



@DisplayName("사진 서비스 테스트")
class PhotoServiceImplTest extends BaseSpringBootTest {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("사진 업로드")
    void imgUpload() throws IOException {

        //given
        MockMultipartFile file = new MockMultipartFile("image.jpg", "test.jpg", "image/jpg",
                new FileInputStream("src/test/resources/image/test.jpg"));

        CreateBoardModel createBoardModel = new CreateBoardModel("제목", "내용", "PHOTO", "ALL", "WEDDING", List.of(file));

        Board board = boardService.createBoard(createBoardModel, token);

        //when
        photoService.imgUpload(createBoardModel, board);

        //then
    }

}