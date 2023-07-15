package com.laveberry.photoniz.photo.repository;

import com.laveberry.photoniz.photo.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoJpaRepository extends JpaRepository<Photo, Integer> {
}
