package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.BoardDetailModel;

public interface BoardService {


    BoardDetailModel findBoardDetail(Integer boardId);
}
