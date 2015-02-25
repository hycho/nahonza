package com.bigcho.mps.application.album.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.support.mybatis.BaseSqlSessionDaoSupport;

@Repository("youtubeDao")
public class YoutubeDao extends BaseSqlSessionDaoSupport {
	static final Logger log = LoggerFactory.getLogger(YoutubeDao.class);
	
	public List<Map<String, Object>> findAllYoutubes() {
		return getSqlSession().selectList("youtubeDao.findAllYoutubes");
	}
	
	public List<Map<String, Object>> findYoutubesByAlbumId(Map<String, Object> params) {
		return getSqlSession().selectList("youtubeDao.findYoutubesByAlbumId", params);
	}
	
	public int saveYoutube(Map<String, Object> params) {
		return getSqlSession().insert("youtubeDao.saveYoutube", params);
	}
	
	public int removeYoutubeByAlbumId(Map<String, Object> params) {
		return getSqlSession().insert("youtubeDao.removeYoutubeByAlbumId", params);
	}
	
}