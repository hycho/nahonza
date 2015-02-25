package com.bigcho.mps.application.user.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.support.mybatis.BaseSqlSessionDaoSupport;

@Repository("userDao")
public class UserDao extends BaseSqlSessionDaoSupport {
	static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	public List<Map<String, Object>> findUserByUserId(Map<String, Object> params) {
		return getSqlSession().selectList("userDao.findUserByUserId", params);
	}
	
	public int saveUser(Map<String, Object> params) {
		return getSqlSession().insert("userDao.saveUser", params);
	}
	
}