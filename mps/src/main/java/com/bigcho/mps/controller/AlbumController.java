package com.bigcho.mps.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.service.AlbumService;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {
	
	@Resource(name = "albumService")
	private AlbumService albumService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/album/list";
	}
	
	@RequestMapping(value = "/choutube", method = RequestMethod.GET)
	public String choutube() {
		return "/album/choutube";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Album choutube(@RequestBody Album album) {
		return albumService.saveAlbum(album);
	}
	
}
