package com.dub.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.dub.spring.controller.UserPrincipal;
import com.dub.spring.oauth.entities.MyUser;


@Service
public class UserServiceImpl implements UserService {
	
	@Value("${usersResourceUriBase}")
	String resourceUriBase;
	
	// = "http://localhost:9090/user/";
	
	RestOperations restTemplate = new RestTemplate();
	
	
	
	//@Autowired UserRepository userRepository;

	@Override  
	@Transactional    
	public UserPrincipal loadUserByUsername(String username) {	
		//MyUser user = userRepository.getByUsername(username);
    
		MyUser userAlt =
		        restTemplate.getForObject(
		        					resourceUriBase + username, 
		        					MyUser.class);
	
		//System.out.println(user.getHashedPassword());
		System.out.println(userAlt.getHashedPassword());
		//System.out.println(userAlt.getHashedPassword()
		//							.equals(user.getHashedPassword()));
		
		
		UserPrincipal principal = new UserPrincipal(userAlt);
	    	    
		// make sure the authorities and password are loaded
		principal.getAuthorities().size();
		principal.getPassword();
		return principal;
	}

}