package com.dub.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dub.spring.oauth.entities.MyUser;
import com.dub.spring.services.MyUserService;



@RestController
public class UserRestEndpoint {
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Autowired
	private MyUserService myUserService;
	
	@RequestMapping("/user/{username}")
	public MyUser getUser(@PathVariable("username") String username) {
			
		System.out.println("users-service getUser " + url);
				
		MyUser user = myUserService.loadUserByUsername(username);
		
		return user;
	}

}
