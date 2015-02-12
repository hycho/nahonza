package com.bigcho.mps.application.album.contoller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.application.album.service.AlbumService;
import com.bigcho.mps.support.security.entity.User;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {

	@Resource(name = "albumService")
	private AlbumService albumService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession session) {
		return "/album/list";
	}
	
	@RequestMapping(value = "/choutube", method = RequestMethod.GET)
	public String choutube(@RequestParam(required=false) String albumId, Model model) {
		model.addAttribute("albumId", albumId);
		return "/album/choutube";
	}
	
	@RequestMapping(value = "/saveAlbum", method = RequestMethod.POST)
	public @ResponseBody int saveAlbum(@RequestBody Map<String, Object> params) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		params.put("userId", user.getUserId());
		return albumService.saveAlbum(params);
	}
	
	@RequestMapping(value = "/findAllAlbumList", method =  {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody List<Map<String, Object>> findAllAlbumList() {
		return albumService.findAllAlbums();
	}
	
	@RequestMapping(value = "/findAlbumsByUserId", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findByAlbumId(@RequestBody Map<String, Object> params) {
		return albumService.findAlbumsByUserId(params);
	}
}
