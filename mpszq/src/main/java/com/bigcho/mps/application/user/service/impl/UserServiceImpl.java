package com.bigcho.mps.application.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bigcho.mps.application.user.dao.UserDao;
import com.bigcho.mps.application.user.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "userDao")	
	private UserDao userDao;

	public List<Map<String, Object>> findUserByUserId(Map<String, Object> params) {
		return userDao.findUserByUserId(params);
	}
	
	public int saveUser(Map<String, Object> params) {
		return userDao.saveUser(params);
	}
	
}