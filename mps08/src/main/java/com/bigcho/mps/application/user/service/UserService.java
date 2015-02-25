package com.bigcho.mps.application.user.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public List<Map<String, Object>> findUserByUserId(Map<String, Object> params);
	public int saveUser(Map<String, Object> params);
}
