package com.ground;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;

import com.ground.common.constants.HelloService;
import com.ground.common.constants.HelloServiceImpl;

@Configuration
@EnableCaching
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
	@Bean
	HelloService helloService() {
		return new HelloServiceImpl();
	}

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache/ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	@Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
