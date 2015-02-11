package com.bigcho.mps.application.album.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcho.mps.application.album.dao.AlbumDao;
import com.bigcho.mps.application.album.service.AlbumService;
	

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

    @Resource(name = "albumDao")	
	private AlbumDao albumDao;
    
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public int saveAlbum(Map<String, Object> params) {
		return albumDao.saveAlbum(params);
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
}