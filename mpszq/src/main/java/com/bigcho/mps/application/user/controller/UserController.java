package com.bigcho.mps.application.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.application.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/findUserByUserId", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findUserByUserId(@RequestBody Map<String, Object> params) {
		return userService.findUserByUserId(params);
	}
	
}
