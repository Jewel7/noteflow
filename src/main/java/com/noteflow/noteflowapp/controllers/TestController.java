package com.noteflow.noteflowapp.controllers;

import com.noteflow.noteflowapp.repositories.ConversationRepository;
import com.noteflow.noteflowapp.util.RedisConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    ConversationRepository conversationRepository;
    RedisConnectionUtil redisConnectionUtil;

    @Autowired
    public TestController(ConversationRepository conversationRepository, RedisConnectionUtil redisConnectionUtil) {
        this.conversationRepository = conversationRepository;
        this.redisConnectionUtil = redisConnectionUtil;
    }

    @GetMapping("/about")
    public String about() {
        return "About";
    }

    @GetMapping("/redisTest")
    public void rediTest() {
        redisConnectionUtil.connect();
        redisConnectionUtil.write();
        redisConnectionUtil.read();
    }

    @GetMapping("/")
    public String main() {
        return "NOTEFLOW MAIN PAGE";
    }

}
