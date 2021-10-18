package com.example.practice.redis;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import org.slf4j.Logger;

@Configuration
public class CacheConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(CacheConfiguration.class);
	
    @Bean
    CacheManagerCustomizer<RedisCacheManager> customizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements CacheManagerCustomizer<RedisCacheManager>{

        @Override
        public void customize(RedisCacheManager cacheManager) {
            logger.info("customizer invoked!!");
        }
    }
}