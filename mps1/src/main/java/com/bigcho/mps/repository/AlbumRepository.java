package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.entity.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Album findByAlbumId(String albumId);
}
