package com.bigcho.mps.application.album.service.impl;

import java.util.List;
import java.util.Map;

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