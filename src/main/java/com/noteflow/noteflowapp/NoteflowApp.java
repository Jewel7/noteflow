package com.noteflow.noteflowapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NoteflowApp {

    public static void main(String[] args) {
        SpringApplication.run(NoteflowApp.class, args);
//        JedisPool pool = new JedisPool("localhost", 6379);
//
//        try (Jedis jedis = pool.getResource()) {
//            // Store & Retrieve a simple string
//            jedis.set("foo", "bar");
//            System.out.println(jedis.get("foo")); // prints bar
//
//            // Store & Retrieve a HashMap
//            Map<String, String> hash = new HashMap<>();
//            ;
//            hash.put("name", "John");
//            hash.put("surname", "Smith");
//            hash.put("company", "Redis");
//            hash.put("age", "29");
//            jedis.hset("user-session:123", hash);
//            System.out.println(jedis.hgetAll("user-session:123"));
//            // Prints: {name=John, surname=Smith, company=Redis, age=29}
//        }
    }
}
