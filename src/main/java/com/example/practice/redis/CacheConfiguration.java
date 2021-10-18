package com.example.practice.redis;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

@Configuration
public class CacheConfiguration {
	
    @Bean
    CacheManagerCustomizer<RedisCacheManager> customizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements CacheManagerCustomizer<RedisCacheManager>{

        @Override
        public void customize(RedisCacheManager cacheManager) {
            System.out.println("customizer invoked!!");
        }
    }
}