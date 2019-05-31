package com.dub.spring.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.dub.spring.oauth.entities.MyUser;


//@Validated
public interface MyUserService {
   
    MyUser loadUserByUsername(String username);// custom implementation

    
}
