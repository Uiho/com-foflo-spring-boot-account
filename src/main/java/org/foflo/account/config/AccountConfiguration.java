package org.foflo.account.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("org.uchoi.account") // search the com.company package for @Component classes
@ImportResource({"classpath:data-context.xml"}) // XML 
@PropertySource("classpath:application.properties") //Properties: It's no longer using, app.pro will be automatically executed.
public class AccountConfiguration {
	
	@Value("${db.driverClassName}")
	String driverClassName;
	
	@Value("${db.url}")
	String url;
	
	@Value("${db.username}")
	String username;
	
	@Value("${db.password}")
	String password;
	
	@Bean
	public DataSource dataSource(){
		DataSource dataSource =new DataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(50);
		dataSource.setMaxIdle(5);
		dataSource.setMinIdle(5);
		dataSource.setTestOnBorrow(false);
		return dataSource;
	}
}

