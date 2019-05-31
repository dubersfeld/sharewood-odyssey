package com.dub.spring.photo.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dub.spring.photo.entities.Photo;


public interface PhotoRepository extends CrudRepository<Photo, Long> {
	List<Photo> findPhotosByUsername(String username);
	List<Photo> findPhotosByShared(boolean shared);
}
