package com.bigcho.mps.application.management.service;

import java.util.List;
import java.util.Map;

public interface UserManageService {
	public List<Map<String, Object>> findUserList(Map<String, Object> params);
}
