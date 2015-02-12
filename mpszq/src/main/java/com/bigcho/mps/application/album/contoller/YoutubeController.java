package com.bigcho.mps.application.album.contoller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigcho.mps.application.album.service.YoutubeService;




@Controller
@RequestMapping(value = "/youtube")
public class YoutubeController {
	
	@Resource(name = "youtubeService")
	private YoutubeService youtubeService;
	
	@RequestMapping(value = "/saveYoutube", method = RequestMethod.POST)
	public @ResponseBody int saveYoutube(@RequestBody Map<String, Object> params) {
		return youtubeService.saveYoutube(params);
	}
	
	@RequestMapping(value = "/findAllYoutubes", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findAllYoutubes() {
		return youtubeService.findAllYoutubes();
	}
	
	@RequestMapping(value = "/findYoutubesByAlbumId", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findYoutubesByAlbumId(@RequestParam Map<String, Object> params) {
		return youtubeService.findYoutubesByAlbumId(params);
	}
}
