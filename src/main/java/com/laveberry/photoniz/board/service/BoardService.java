package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.BoardDetailModel;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    BoardDetailModel findBoardDetail(Integer boardId);

    Page<BoardListModel> findBoardList(String type, Pageable pageable);

    Board createBoard(CreateBoardModel createBoardModel, String token);
}
