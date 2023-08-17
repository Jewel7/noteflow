package com.noteflow.noteflowapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NoteflowApp {

    public static void main(String[] args) {
        SpringApplication.run(NoteflowApp.class, args);
    }

}
