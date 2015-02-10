package com.bigcho.mps.service.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.entity.User;
import com.bigcho.mps.repository.AlbumRepository;
import com.bigcho.mps.service.AlbumService;


@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
    private AlbumRepository albumRep;
		
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public Album saveAlbum(Album album) {
		return albumRep.save(album);
	}
	
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Album> findAllAlbumList() {
		return albumRep.findAll();
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public Album findByAlbumId(String albumId) {
		return 	albumRep.findByAlbumId(albumId);
	}
	
}