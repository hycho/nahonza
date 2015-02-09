package com.bigcho.mps.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.entity.User;
import com.bigcho.mps.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/findUserInfoByUserId", method = RequestMethod.POST)
	public @ResponseBody User findUserInfoByUserId(@RequestBody String userId) {
		return userService.findUserByUserId(userId);
	}
	
}
