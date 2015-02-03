package com.bigcho.mps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {
	
	/**
	 * 리스트 페이지로 이동합니다.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "/dashboard/main";
	}
	
}
