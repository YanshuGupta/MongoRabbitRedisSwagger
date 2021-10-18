//package com.example.practice.redis;
//
//import java.time.Duration;
//
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
//
//@Configuration
//public class RedisConfig {
//
//	@Bean
//	public RedisCacheConfiguration cacheConfiguration() {
//		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
//				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//	}
//
//	@Bean
//	CacheManagerCustomizer<ConcurrentMapCacheManager> customizer() {
//		return new ConcurrentCustomizer();
//	}
//
//	class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
//
//		@Override
//		public void customize(ConcurrentMapCacheManager cacheManager) {
//			cacheManager.setAllowNullValues(false);
//			System.out.println("customizer invoked!!");
//		}
//	}
//
//}
