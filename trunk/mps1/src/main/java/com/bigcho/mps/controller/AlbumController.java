package com.bigcho.mps.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.service.AlbumService;
import com.bigcho.mps.service.YoutubeService;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {
	
	@Resource(name = "albumService")
	private AlbumService albumService;
	
	@Resource(name = "youtubeService")
	private YoutubeService youtubeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/album/list";
	}
	
	@RequestMapping(value = "/choutube", method = RequestMethod.GET)
	public String choutube(@RequestParam(required=false) String albumId, Model model) {
		model.addAttribute("albumId", albumId);
		return "/album/choutube";
	}
	
	@RequestMapping(value = "/saveAlbum", method = RequestMethod.POST)
	public @ResponseBody Album saveAlbum(@RequestBody Album album) {
		return albumService.saveAlbum(album);
	}
	
	@RequestMapping(value = "/findAllAlbumList", method = RequestMethod.POST)
	public @ResponseBody List<Album> findAllAlbumList() {
		return albumService.findAllAlbumList();
	}
	
	@RequestMapping(value = "/findByAlbumId", method = RequestMethod.POST)
	public @ResponseBody Album findByAlbumId(@RequestParam String albumId) {
		return albumService.findByAlbumId(albumId);
	}
	
}
