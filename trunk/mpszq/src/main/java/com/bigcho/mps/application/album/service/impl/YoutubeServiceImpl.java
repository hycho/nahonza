package com.bigcho.mps.application.album.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcho.mps.application.album.dao.YoutubeDao;
import com.bigcho.mps.application.album.service.YoutubeService;

@Service("youtubeService")
public class YoutubeServiceImpl implements YoutubeService {
	
	@Resource(name = "youtubeDao")	
	private YoutubeDao youtubeDao;
    
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public int saveYoutube(Map<String, Object> params) {
		if(params.get("youtubeId") == null || ((String) params.get("youtubeId")).equals("")) {	//uuid를 userKey(userId)로 잡고 있으며 만약 존재 하지 않을 경우 새로운 Insert건으로 파악 uuid를 생성해서 넘겨준다.
			params.put("youtubeId", UUID.randomUUID().toString());
		}
		
		return youtubeDao.saveYoutube(params);
	}
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Map<String, Object>> findAllYoutubes() {
		return youtubeDao.findAllYoutubes();
	}
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Map<String, Object>> findYoutubesByAlbumId(Map<String, Object> params) {
		return 	youtubeDao.findYoutubesByAlbumId(params);
	}
	
	
}