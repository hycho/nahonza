package com.bigcho.mps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigcho.mps.entity.User;
import com.bigcho.mps.repository.UserRepository;
import com.bigcho.mps.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRep;

	@Override
	public User saveUser(User user) {
		return userRep.save(user);
	}
		
	
}