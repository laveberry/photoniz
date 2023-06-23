package com.laveberry.photoniz.photoBoard.repository;

import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PhotoBoardRepository {
    Optional<PhotoBoard> findBoardDetail(Integer boardId);

    Page<PhotoBoard> findBoardList(MainType type, Pageable pageable);

    PhotoBoard save(PhotoBoard board);

    void deleteBoard(Integer boardId);
}
