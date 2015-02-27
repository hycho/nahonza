package com.bigcho.mps.application.management.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bigcho.mps.application.management.dao.UserManageDao;
import com.bigcho.mps.application.management.service.UserManageService;


@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {
	
	@Resource(name = "userManageDao")	
	private UserManageDao userManageDao;

	@Override
	public List<Map<String, Object>> findUserList(Map<String, Object> params) {
		return userManageDao.findUserList(params);
	}
	
}