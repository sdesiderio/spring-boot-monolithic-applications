package com.example;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

import com.github.benmanes.caffeine.cache.Caffeine;

@SpringBootApplication
@EnableCaching
public class HibernateCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCaffeineApplication.class, args);
	}
	
	@Bean
	public Caffeine<Object, Object> caffeineConfig() {
		return Caffeine.newBuilder().expireAfterWrite(300, TimeUnit.SECONDS).initialCapacity(10);
	}

	@Bean
	public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(caffeine);
		return caffeineCacheManager;
	}

}
