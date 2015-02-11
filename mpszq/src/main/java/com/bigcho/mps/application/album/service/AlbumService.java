package com.bigcho.mps.application.album.service;

import java.util.List;
import java.util.Map;

public interface AlbumService {
	public int saveAlbum(Map<String, Object> params);
	public List<Map<String, Object>> findAllAlbums();
	public List<Map<String, Object>> findAlbumsByUserId(Map<String, Object> params);
}
