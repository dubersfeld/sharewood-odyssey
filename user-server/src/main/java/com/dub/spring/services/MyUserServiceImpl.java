package com.dub.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dub.spring.oauth.entities.MyUser;
import com.dub.spring.repositories.UserRepository;


@Service
public class MyUserServiceImpl implements MyUserService {
	    
	@Autowired UserRepository userRepository;

	@Override  
	@Transactional    
	public MyUser loadUserByUsername(String username) {	
		MyUser user = userRepository.getByUsername(username);
    
		return user;
	}

}