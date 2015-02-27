package com.bigcho.mps.application.management.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.support.mybatis.BaseSqlSessionDaoSupport;

@Repository("userManageDao")
public class UserManageDao extends BaseSqlSessionDaoSupport {
	public List<Map<String, Object>> findUserList(Map<String, Object> params) {
		return getSqlSession().selectList("userManageDao.findUserList", params);
	}
}