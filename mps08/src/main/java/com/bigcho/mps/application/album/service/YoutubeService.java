package com.bigcho.mps.application.album.service;

import java.util.List;
import java.util.Map;

public interface YoutubeService {
	public int saveYoutube(Map<String, Object> params);
	public List<Map<String, Object>> findAllYoutubes();
	public List<Map<String, Object>> findYoutubesByAlbumId(Map<String, Object> params);
}
