package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.repository.BoardRepository;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
@DisplayName("게시판 서비스")
class BoardServiceTest extends BaseSpringBootTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시물 리스트 조회")
    void boardList() {
        //given
        Sort sort = Sort.by(Sort.Direction.ASC, "id"); //오름차순 정렬
        Pageable pageable = PageRequest.of(0, 10, sort);

        //when
        Page<BoardListModel> boardList = boardService.findBoardList("NORMAL", "AUTHOR", pageable); //NORMAL 타입의 게시물 조회

        //then
        assertThat(boardList.getSize()).isEqualTo(10);
        assertThat(boardList.get().findFirst().get().boardId()).isEqualTo(1);
    }

    @Test
    @Disabled
    @DisplayName("게시물 생성")
    void createBoard() {
        CreateBoardModel createBoardModel = new CreateBoardModel("제목", "내용", "QNA", "AUTHOR");

        Board board = Board.builder()
                .title(createBoardModel.title())
                .content(createBoardModel.content())
                .type(BoardType.getType(createBoardModel.type()))
                .build();

        Integer id = boardRepository.save(board).getId();
        assertThat(id).isEqualTo(16);
    }

}
