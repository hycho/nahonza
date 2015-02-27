package com.bigcho.mps.application.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/myhome")
public class myhomeController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "/myhome/main";
	}
	
}
