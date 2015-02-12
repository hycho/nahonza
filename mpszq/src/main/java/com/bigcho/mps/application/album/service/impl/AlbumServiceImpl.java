package com.bigcho.mps.application.album.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcho.mps.application.album.dao.AlbumDao;
import com.bigcho.mps.application.album.dao.YoutubeDao;
import com.bigcho.mps.application.album.service.AlbumService;
	

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

    @Resource(name = "albumDao")	
	private AlbumDao albumDao;
    
    @Resource(name = "youtubeDao")	
	private YoutubeDao youtubeDao;
    
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public int saveAlbum(Map<String, Object> params) {
		int result = 0;
		if(params.get("albumId") == null || ((String) params.get("albumId")).equals("")) {	//uuid를 userKey(userId)로 잡고 있으며 만약 존재 하지 않을 경우 새로운 Insert건으로 파악 uuid를 생성해서 넘겨준다.
			params.put("albumId", UUID.randomUUID().toString());
		}
		
		albumDao.saveAlbum(params);
		
		youtubeDao.removeYoutubeByAlbumId(params);
		
		List<Map<String, Object>> youtubes = (List<Map<String, Object>>) params.get("youtubes");
		for(Map<String, Object> youtube : youtubes) {
			if(youtube.get("youtubeId") == null || ((String) youtube.get("youtubeId")).equals("")) {	//uuid를 userKey(userId)로 잡고 있으며 만약 존재 하지 않을 경우 새로운 Insert건으로 파악 uuid를 생성해서 넘겨준다.
				youtube.put("youtubeId", UUID.randomUUID().toString());
			}
			youtube.put("albumId", params.get("albumId"));
			result = youtubeDao.saveYoutube(youtube);
		}

		return result;
	}
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Map<String, Object>> findAllAlbums() {
		return albumDao.findAllAlbums();
	}
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Map<String, Object>> findAlbumsByUserId(Map<String, Object> params) {
		return 	albumDao.findAlbumsByUserId(params);
	}

	@Override
	public List<Map<String, Object>> findAllAlbumsByAlbumId(Map<String, Object> params) {
		return 	albumDao.findAllAlbumsByAlbumId(params);
	}
}