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

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
	@Autowired
    private AlbumRepository albumRep;
	
	@Autowired
    private YoutubeRepository youtubeRep;
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public Album saveAlbum(Album album) {
		return albumRep.save(album);
	}
}