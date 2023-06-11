package com.laveberry.photoniz.photoBoard.repository;

import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PhotoBoardJpaRepository extends JpaRepository<PhotoBoard, Integer> {
    Page<PhotoBoard> findByTypeAndDeleteYnIsFalseOrderById(MainType mainType, Pageable pageable);

    Optional<PhotoBoard> findByIdAndDeleteYnIsFalse(Integer id);
}
