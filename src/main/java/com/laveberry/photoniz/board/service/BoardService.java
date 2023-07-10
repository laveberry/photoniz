package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.BoardDetailModel;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.model.UpdateBoardModel;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    BoardDetailModel findBoardDetail(Integer boardId);

    Page<BoardListModel> findBoardList(String type, String mainType, Pageable pageable);

    Board createBoard(CreateBoardModel createBoardModel, String token);

    Integer updateBoard(UpdateBoardModel updateBoardModel, String token);

    void deleteBoard(Integer boardId, String token);
}
