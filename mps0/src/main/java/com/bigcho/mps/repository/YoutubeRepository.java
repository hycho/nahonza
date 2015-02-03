package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.entity.Youtube;

@Repository
public interface YoutubeRepository extends JpaRepository<Youtube, Long> {}
