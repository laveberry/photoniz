package com.laveberry.photoniz.photo.repository;

import com.laveberry.photoniz.photo.domain.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhotoRepositoryImpl implements PhotoRepository {

    private final PhotoJpaRepository photoJpaRepository;

    @Override
    public Photo save(Photo photo) {
        return photoJpaRepository.save(photo);
    }
}
