package com.bigcho.mps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcho.mps.entity.SecureResource;
import com.bigcho.mps.repository.SecureResourceRepository;
import com.bigcho.mps.service.SecureResourceService;


@Service("secureResourceService")
public class SecureResourceServiceImpl implements SecureResourceService {
	
	@Autowired
    private SecureResourceRepository secureResourceRep;

	@Override
	public SecureResource saveSecureResource(SecureResource secureResource) {
		return secureResourceRep.save(secureResource);
	}
		
	
}