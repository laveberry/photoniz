package com.laveberry.photoniz.photoBoard.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardListModel;
import com.laveberry.photoniz.photoBoard.repository.PhotoBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사진게시판 서비스")
class PhotoBoardServiceTest extends BaseSpringBootTest {

    @Autowired
    private PhotoBoardService photoBoardService;

    @Autowired
    private PhotoBoardRepository photoBoardRepository;

    @Test
    @DisplayName("사진 게시물 리스트 조회")
    void findPhotoBoardList() {
        //given
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);

        //when
        //PHOTO 타입 게시물 조회
        Page<PhotoBoardListModel> photoBoardList = photoBoardService.findBoardList("PHOTO", pageable);

        //then
        assertThat(photoBoardList.getSize()).isEqualTo(3);
        assertThat(photoBoardList.get().findFirst().get().boardId()).isEqualTo(1);
    }
}