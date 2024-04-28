package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;


@SpringBootApplication
@EnableCaching
public class MetricsWithActuatorApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MetricsWithActuatorApplication.class, args);
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

}
