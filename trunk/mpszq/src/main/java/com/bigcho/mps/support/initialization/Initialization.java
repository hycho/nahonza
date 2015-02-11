package com.bigcho.mps.support.initialization;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Initialization {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PostConstruct
    public void initialize() {
		initializeUser();
    }
	
	public void initializeUser() {
		
		
		UUID.randomUUID().toString();
		
		/*
		Authority author = new Authority();
		author.setAuthorityCode("ROLE_USER");
		author.setName("유저 권한");
				
		User user = new User();
		user.setId("user1");
		user.setPassword(passwordEncoder.encode("user1"));
		user.setName("Cho Ho Young");
		user.setUseFlag("0");
		user.setDescription("Master");
		user.setEmail("kofwhgh@gmail.com");
		user.addAuthority(author);
		userService.saveUser(user);
				
		SecureResource sr = new SecureResource();
		sr.setName("main author");
		sr.setPattern("/main");
		sr.setType("url");
		sr.addAuthority(author);
		secureResourceService.saveSecureResource(sr);
		
		SecureResource sr1 = new SecureResource();
		sr1.setName("main author");
		sr1.setPattern("/album/**");
		sr1.setType("url");
		sr1.addAuthority(author);
		secureResourceService.saveSecureResource(sr1);
		*/
	}

}
