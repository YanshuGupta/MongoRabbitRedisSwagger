package com.example.practice.redis;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
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
        	
        	RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        			
        			
//        	RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//        			.entryTtl(Duration.ofSeconds(2))
//        			.disableCachingNullValues();
//        	config.usePrefix();
        	Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        	configurationMap.put("persons", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(2)));  
        	configurationMap.put("cache2", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2)));
        	cacheManager.builder().withInitialCacheConfigurations(configurationMap);
//        			.withCacheConfiguration("1234", RedisCacheConfiguration.defaultCacheConfig()
//        	        .entryTtl(Duration.ofSeconds(2)))
//        			.cacheDefaults(config);
            System.out.println("customizer invoked!!");
        }
    }
	
//	

}