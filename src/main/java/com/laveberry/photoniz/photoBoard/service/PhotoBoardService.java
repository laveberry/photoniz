package com.laveberry.photoniz.photoBoard.service;

import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardDetailModel;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardListModel;
import com.laveberry.photoniz.photoBoard.model.CreatePhotoBoardModel;
import com.laveberry.photoniz.photoBoard.model.UpdatePhotoBoardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhotoBoardService {

    PhotoBoardDetailModel findBoardDetail(Integer boardId);

    Page<PhotoBoardListModel> findPhotoBoardList(String type, Pageable pageable);

    PhotoBoard createBoard(CreatePhotoBoardModel createBoardModel, String token);

    Integer updateBoard(UpdatePhotoBoardModel updatePhotoBoardModel, String token);

    void deleteBoard(Integer boardId, String token);
}
