package com.bigcho.mps.application.album.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.support.mybatis.BaseSqlSessionDaoSupport;

@Repository("albumDao")
public class AlbumDao extends BaseSqlSessionDaoSupport {
	static final Logger log = LoggerFactory.getLogger(AlbumDao.class);
	
	public List<Map<String, Object>> findAllAlbums() {
		return getSqlSession().selectList("albumDao.findAllAlbums");
	}
	
	public List<Map<String, Object>> findAlbumsByUserId(Map<String, Object> params) {
		return getSqlSession().selectList("albumDao.findAllAlbums", params);
	}
	
	public int saveAlbum(Map<String, Object> params) {
		return getSqlSession().insert("albumDao.saveAlbum", params);
	}
	
	public int saveUserAlbum(Map<String, Object> params) {
		return getSqlSession().insert("albumDao.saveUserAlbum", params);
	}
	
	public Map<String, Object> findAlbumByAlbumId(Map<String, Object> params) {
		return getSqlSession().selectOne("albumDao.findAlbumByAlbumId", params);
	}
	
}