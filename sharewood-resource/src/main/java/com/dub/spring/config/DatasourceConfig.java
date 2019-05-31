package com.dub.spring.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@EnableConfigurationProperties
public class DatasourceConfig {
	
	@Bean("photos")
	@ConfigurationProperties(prefix="photo.datasource")
	DatasourceProperties photoDsp() {
		return new DatasourceProperties();
	}
	
	@Bean("tokens")
	@ConfigurationProperties(prefix="token.datasource")
	DatasourceProperties tokenDsp() {
		return new DatasourceProperties();
	}

	@Bean("primaryDataSource")
    @Primary
    public DataSource primaryDataSource(final @Qualifier("tokens") DatasourceProperties dsp) {
			
		DataSource dataSource = DataSourceBuilder
							.create()
							.driverClassName(dsp.getDriverClassName())
							.url(dsp.getUrl())
							.username(dsp.getUsername())
							.password(dsp.getPassword())
							.build();
				
		return dataSource;
    }
 
 
    @Bean("secondaryDataSource")
    public DataSource secondaryDataSource(final @Qualifier("photos") DatasourceProperties dsp) {
    	 	
    	DataSource dataSource = DataSourceBuilder
				.create()
				.driverClassName(dsp.getDriverClassName())
				.url(dsp.getUrl())	
				.username(dsp.getUsername())
				.password(dsp.getPassword())	
				.build();
    		    
        return dataSource;
    }
	
}
