package com.laveberry.photoniz.photoBoard.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.photoBoard.model.CreatePhotoBoardModel;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardDetailModel;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardListModel;
import com.laveberry.photoniz.photoBoard.repository.PhotoBoardRepository;
import com.laveberry.photoniz.work.enums.WorkType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Disabled
@DisplayName("사진게시판 서비스")
class PhotoBoardServiceTest extends BaseSpringBootTest {

    @Autowired
    private PhotoBoardService photoBoardService;

    @Autowired
    private PhotoBoardRepository photoBoardRepository;

    @Test
    @DisplayName("사진 게시물 리스트 조회")
    void findPhotoBoardListTest() {
        //given
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);

        //when
        //PHOTO 타입 게시물 조회
        Page<PhotoBoardListModel> photoBoardList = photoBoardService.findPhotoBoardList("PHOTO", pageable);

        //then
        assertThat(photoBoardList.getSize()).isEqualTo(10);
        assertThat(photoBoardList.get().findFirst().get().boardId()).isEqualTo(1);
    }

    @Test
    @DisplayName("사진 게시판 상세조회")
    void boardDetailTest(){
        Optional<PhotoBoard> boardDetail = photoBoardRepository.findBoardDetail(1);
        assertThat(boardDetail.get().getId()).isEqualTo(1);
        System.out.println("제목 조회 ===> " + boardDetail.get().getTitle());
    }

    @Test
    @DisplayName("사진 게시물 생성")
    void createBoardTest(){
        CreatePhotoBoardModel createPhotoBoardModel = new CreatePhotoBoardModel("제목", "내용", MainType.PHOTO.getType(), WorkType.PERSONAL.getValue());

        PhotoBoard photoBoard = PhotoBoard.builder()
                .title(createPhotoBoardModel.title())
                .content(createPhotoBoardModel.content())
                .type(MainType.valueOf(createPhotoBoardModel.mainType()))
                .workType(WorkType.valueOf(createPhotoBoardModel.workType()))
                .build();

        PhotoBoard response = photoBoardRepository.save(photoBoard);
        System.out.println("response.getType()  => " + response.getType()); // FIXME 테스트는 print문 보단 assertThat 등으로 검증하는것이 좋음
    }

}