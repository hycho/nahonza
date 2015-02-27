package com.bigcho.mps.application.management.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.application.management.service.UserManageService;

@Controller
@RequestMapping(value = "/userManage")
public class UserManageController {
	
	@Resource(name = "userManageService")
	private UserManageService userManageService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession session) {
		return "/management/usermanage_list";
	}
	
	@RequestMapping(value = "/findUserList", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findUserList(@RequestParam Map<String, Object> params) {
		return userManageService.findUserList(params);
	}
	
	@RequestMapping(value = "/viewUserInfoDialog", method = RequestMethod.GET)
	public String viewUserInfoDialog(HttpSession session) {
		return "/management/usermanage_view_dialog";
	}
	
}
