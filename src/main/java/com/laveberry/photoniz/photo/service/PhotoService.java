package com.laveberry.photoniz.photo.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    void imgUpload(CreateBoardModel createBoardModel, List<MultipartFile> multipartFile, Board board);

}
