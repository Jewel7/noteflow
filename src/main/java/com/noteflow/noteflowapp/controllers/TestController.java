package com.noteflow.noteflowapp.controllers;

import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.repositories.ConversationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    ConversationRepository conversationRepository;

    //constructor injection is the preferred method for spring DI
    @Autowired
    public TestController(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @GetMapping("/about")
    public String about() {
        return "About";
    }

    @GetMapping("/redisTest")
    public void rediTest() {
        Conversation conversation = new Conversation("title1");
        conversationRepository.save(conversation);
        conversationRepository.findById(conversation.getId().toString());

    }

    @GetMapping("/")
    public String main() {
        return "NOTEFLOW MAIN PAGE";
    }

}
