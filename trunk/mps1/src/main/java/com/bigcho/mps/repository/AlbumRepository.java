package com.bigcho.mps.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.entity.Album;
import com.bigcho.mps.entity.User;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Album findByAlbumId(String albumId);
}
