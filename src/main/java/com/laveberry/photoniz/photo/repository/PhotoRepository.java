package com.laveberry.photoniz.photo.repository;

import com.laveberry.photoniz.photo.domain.Photo;

public interface PhotoRepository {

    Photo save(Photo photo);

}
