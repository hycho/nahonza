package com.bigcho.mps.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.entity.Youtube;
import com.bigcho.mps.repository.AlbumRepository;
import com.bigcho.mps.repository.YoutubeRepository;
import com.bigcho.mps.service.AlbumService;
import com.bigcho.mps.service.YoutubeService;

@Service("youtubeService")
public class YoutubeServiceImpl implements YoutubeService {
	@Autowired
    private AlbumRepository albumRep;
	
	@Autowired
    private YoutubeRepository youtubeRep;

	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Youtube> saveYoutube(List<Youtube> youtubes) {
		return youtubeRep.save(youtubes);
	}
	
	
	
}