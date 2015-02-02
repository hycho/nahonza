package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bigcho.mps.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {}
