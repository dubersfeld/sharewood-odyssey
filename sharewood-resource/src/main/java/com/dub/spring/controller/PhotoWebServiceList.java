package com.dub.spring.controller;

import java.util.List;

import com.dub.spring.photo.entities.Photo;

/** Helper class used by REST requests */
public class PhotoWebServiceList {
    private List<Photo> photos;

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}   
}
