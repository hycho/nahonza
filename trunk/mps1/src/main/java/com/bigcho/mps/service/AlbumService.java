package com.bigcho.mps.service;

import java.util.Collection;
import java.util.List;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.entity.User;

public interface AlbumService {
	public Album saveAlbum(Album album);
	public List<Album> findAllAlbumList();
	public Album findByAlbumId(String albumId);
}
