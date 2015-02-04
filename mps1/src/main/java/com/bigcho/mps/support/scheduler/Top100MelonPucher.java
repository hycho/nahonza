package com.bigcho.mps.support.scheduler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.service.AlbumService;

@Component("top100MelonPucher")
public class Top100MelonPucher {
	@Resource(name = "albumService")
	private AlbumService albumService;
	
	public void printAnotherMessage(){
        System.out.println("I am called by Quartz jobBean using CronTriggerFactoryBean");
        List<Album> albumList = albumService.findAllAlbumList();
        
        for(Album album : albumList) {
        	System.out.println(album.getTitle());
        }
        
    }
}
