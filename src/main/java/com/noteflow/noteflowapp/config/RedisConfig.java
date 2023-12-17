package com.noteflow.noteflowapp.config;

import com.noteflow.noteflowapp.util.RedisConnectionUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedisConfig {

    // uses the Singleton pattern
    //tells Spring to manage the only Redis instance available
    @Bean
    public RedisConnectionUtil redisConnectionUtil() {
        return RedisConnectionUtil.getInstance();
    }
}
