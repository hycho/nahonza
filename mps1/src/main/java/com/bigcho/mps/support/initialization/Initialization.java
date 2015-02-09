package com.bigcho.mps.support.initialization;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bigcho.mps.entity.Authority;
import com.bigcho.mps.entity.SecureResource;
import com.bigcho.mps.entity.User;
import com.bigcho.mps.service.SecureResourceService;
import com.bigcho.mps.service.UserService;

@Component
public class Initialization {
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "secureResourceService")
	private SecureResourceService secureResourceService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PostConstruct
    public void initialize() {
		initializeUser();
    }
	
	public void initializeUser() {
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
	}

}
