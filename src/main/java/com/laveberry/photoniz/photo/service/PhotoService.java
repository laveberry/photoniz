package com.laveberry.photoniz.photo.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.CreateBoardModel;

public interface PhotoService {

    void imgUpload(CreateBoardModel createBoardModel, Board board);

}