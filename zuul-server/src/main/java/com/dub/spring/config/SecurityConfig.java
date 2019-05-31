package com.dub.spring.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfig 
						extends WebSecurityConfigurerAdapter {
	
	
	@Bean
    protected SessionRegistry sessionRegistryImpl() {
        return new SessionRegistryImpl();      
    }
	
	@Bean
	public CsrfTokenRepository csrfTokenRepository(){
	    HttpSessionCsrfTokenRepository repository 
	    						= new HttpSessionCsrfTokenRepository();
	    repository.setHeaderName("X-XSRF-TOKEN");
	    return repository;
	}

	
	@Override
    protected void configure(HttpSecurity security) 
    		throws Exception {
        security
        		.authorizeRequests()           
                    .antMatchers("/authorization/**").permitAll()
                    .antMatchers("/sharewood/**").permitAll()
                    .and().csrf()
                    .disable();
    				//.csrfTokenRepository(csrfTokenRepository());
                  
	}
}
