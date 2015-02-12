package com.bigcho.mps.application.album.service;

import java.util.List;
import java.util.Map;

public interface AlbumService {
	public Map<String, Object> saveAlbum(Map<String, Object> params);
	public List<Map<String, Object>> findAllAlbums();
	public Map<String, Object> findAlbumByAlbumId(Map<String, Object> params);
	public List<Map<String, Object>> findAlbumsByUserId(Map<String, Object> params);
}
