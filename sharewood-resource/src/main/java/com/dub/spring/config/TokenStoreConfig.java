package com.dub.spring.config;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "myauthEntityManagerFactory",
		transactionManagerRef = "myauthTransactionManager",
		basePackages = { "com.dub.spring.oauth" }
)
public class TokenStoreConfig {
	
	@Value("${myauthorization.jpa.hibernate.naming.physical-strategy:default}")
	private String physicalStrategy;


	@Primary
	@Bean(name = "myauthEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean 
			myauthEntityManagerFactory(
					EntityManagerFactoryBuilder builder,
					@Qualifier("primaryDataSource") DataSource dataSource) {
	
		LocalContainerEntityManagerFactoryBean forge =	
			 builder
			 .dataSource(dataSource)
			 .packages("com.dub.spring.oauth.entities")
			 .persistenceUnit("myauthDB")
			 .properties(jpaProperties())
			 .build();
		System.err.println("myauthEntityManagerFactory built");
		return forge;
	}

	@Primary
	@Bean(name = "myauthTransactionManager")
	public PlatformTransactionManager 
		myauthTransactionManager(
				@Qualifier("myauthEntityManagerFactory") EntityManagerFactory
				myauthEntityManagerFactory) {
		
		PlatformTransactionManager manager =
		 new JpaTransactionManager(myauthEntityManagerFactory);
		System.out.println("myauthTransactionManager built");
		return manager;
	}
	
	
	protected Map<String, Object> jpaProperties() {
	    Map<String, Object> props = new HashMap<>();
		       
	    if (!physicalStrategy.equals("default")) {
	    	props.put("hibernate.physical_naming_strategy", physicalStrategy);	
	    }
	    
	    return props;
	}
	
}

