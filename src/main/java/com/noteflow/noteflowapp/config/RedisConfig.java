package com.noteflow.noteflowapp.config;

import com.noteflow.noteflowapp.util.RedisConnectionUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedisConfig {

    // uses the Singleton pattern
    // tells Spring to manage the only Redis instance available
    // we only have one instance because every time we create an instance, we connect to the cluster
    // we only want to connect to the cluster once because it takes up a lot of memory and network IO
    @Bean
    public RedisConnectionUtil redisConnectionUtil() {
        return RedisConnectionUtil.getInstance();
    }
}
