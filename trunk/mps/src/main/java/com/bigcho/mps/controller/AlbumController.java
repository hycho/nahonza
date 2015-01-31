package com.bigcho.mps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {
	
	/**
	 * 리스트 페이지로 이동합니다.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/album/list";
	}
	
	/**
	 * 리스트 페이지로 이동합니다.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/choutube", method = RequestMethod.GET)
	public String choutube() {
		return "/album/choutube";
	}
	
}
