package com.ground.service.database.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ground.service.database.jdbc.ExportsJDBC_BS;
import com.ground.service.database.jdbc.GDTransactionManager;

@Configuration
@EnableCaching
@EnableAspectJAutoProxy
@ImportResource("classpath:/spring-xml/spring-resource.xml")
public class DatabaseConfiguration {
	
	@Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mhtsoft1_ground");
        driverManagerDataSource.setUsername("mhtsoft1_ground");
        driverManagerDataSource.setPassword("mhtsoft1_ground");
        return driverManagerDataSource;
    }   
	
	@Bean   
	public DataSourceTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean   
	public GDTransactionManager gdTxManager() {
		GDTransactionManager transactionManager = new GDTransactionManager();
		transactionManager.setTransactionManager(transactionManager());
	    return transactionManager;
	}
	
	@Bean   
	public ExportsJDBC_BS exportsJDBC_BS() {
	    return new ExportsJDBC_BS();
	}
	
}
