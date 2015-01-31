package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigcho.mps.entity.Youtube;

public interface YoutubeRepository extends JpaRepository<Youtube, Long> {
	//Page<> findByResourcePath(String resourcePath, Pageable pageable);
	
	//@Query("SELECT SC FROM MhSectionCode SC WHERE SC.sectionCodeId.sectionCode LIKE :#{#sectionCodeId.sectionCode}% AND SC.sectionCodeId.storyId = :#{#sectionCodeId.storyId}")
	//List<MhSectionCode> findBySectionCodeId(@Param("sectionCodeId") MhSectionCodePK sectionCodeId);
}
