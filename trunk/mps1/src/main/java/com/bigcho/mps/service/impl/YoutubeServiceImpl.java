package com.bigcho.mps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bigcho.mps.entity.Youtube;
import com.bigcho.mps.repository.YoutubeRepository;
import com.bigcho.mps.service.YoutubeService;

@Service("youtubeService")
public class YoutubeServiceImpl implements YoutubeService {
	@Autowired
    private YoutubeRepository youtubeRep;

	/**
	 * YoutubeList를 저장한다. 각 유튜브 안에는 Album항목이 저장이 되어야 한다.
	 */
	@Override
	@Transactional(value = "transactionManager", rollbackFor=Exception.class)
	public List<Youtube> saveYoutubeList(List<Youtube> youtubes) {
		return youtubeRep.save(youtubes);
	}
	
}