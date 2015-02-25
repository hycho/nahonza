package com.bigcho.mps.application.album.contoller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.bigcho.mps.application.album.service.YoutubeService;
import com.bigcho.mps.support.security.entity.User;
import com.bigcho.mps.util.ConvertFFmpeg;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {

	@Resource(name = "albumService")
	private AlbumService albumService;
	
	@Resource(name = "youtubeService")
	private YoutubeService youtubeService;
	
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
	public @ResponseBody Map<String, Object> saveAlbum(@RequestBody Map<String, Object> params) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		params.put("userId", user.getUserId());
		Map<String, Object> result = new HashMap<String, Object>();
		return albumService.saveAlbum(params);
	}
	
	@RequestMapping(value = "/findAllAlbumList", method =  {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody List<Map<String, Object>> findAllAlbumList() {
		return albumService.findAllAlbums();
	}
	
	@RequestMapping(value = "/findAlbumByAlbumId", method =  {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, Object> findAllAlbumsByAlbumId(@RequestParam Map<String, Object> params) {
		return albumService.findAlbumByAlbumId(params);
	}
	
	@RequestMapping(value = "/findAlbumsByUserId", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> findByAlbumId(@RequestBody Map<String, Object> params) {
		return albumService.findAlbumsByUserId(params);
	}
	
	@RequestMapping(value = "/albumDownload", method = RequestMethod.POST)
	public @ResponseBody String albumDownload(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Map<String,Object>> youtubes = youtubeService.findYoutubesByAlbumId(params);
		
		byte[] buffer = new byte[1024];
		
		FileOutputStream fos = new FileOutputStream(ConvertFFmpeg.convPath+ConvertFFmpeg.zipName);
        ZipOutputStream zos = new ZipOutputStream(fos);
        
        for(Map<String, Object> data : youtubes){
                File file = ConvertFFmpeg.remoteConvert("http://www.youtube.com/watch?v="+data.get("playId"));
                zos.putNextEntry(new ZipEntry(data.get("playId")+".mp3"));
                FileInputStream in = new FileInputStream(file);
                
                int len;
                while ((len = in.read(buffer)) > 0){
                	zos.write(buffer, 0, len);
                }
                in.close();
        }
        zos.closeEntry();
        zos.close();
        
        return ConvertFFmpeg.zipName;
	}
	
	
}
