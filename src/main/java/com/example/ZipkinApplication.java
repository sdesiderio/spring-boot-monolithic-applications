package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.example.component.LoggingHandler;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
@EnableCaching
public class ZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}
	
	@Bean
    public Config hazelCastConfig(){
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("customers")
                                .setTimeToLiveSeconds(20));
    }
	
	@Bean
	public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		
		observationRegistry.observationConfig().observationHandler(new LoggingHandler());
		
		return new ObservedAspect(observationRegistry);
		
	}

}
