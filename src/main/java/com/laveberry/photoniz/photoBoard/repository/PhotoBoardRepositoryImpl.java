package com.laveberry.photoniz.photoBoard.repository;

import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PhotoBoardRepositoryImpl implements PhotoBoardRepository {

    private final PhotoBoardJpaRepository photoBoardJpaRepository;
    private final QPhotoBoardRepository qPhotoBoardRepository;

    @Override
    public Optional<PhotoBoard> findBoardDetail(Integer boardId) {
        return photoBoardJpaRepository.findByIdAndDeleteYnIsFalse(boardId);
    }

    @Override
    public Page<PhotoBoard> findBoardList(MainType type, Pageable pageable) {
        return photoBoardJpaRepository.findByTypeAndDeleteYnIsFalseOrderById(type, pageable);
    }

    @Override
    public PhotoBoard save(PhotoBoard board) {
        return photoBoardJpaRepository.save(board);
    }

    @Override
    public void deleteBoard(Integer boardId) {
        qPhotoBoardRepository.softDelete(boardId);
    }
}
