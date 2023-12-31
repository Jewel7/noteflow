package com.noteflow.noteflowapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class Conversation {

    private Set<Question> questions;
    private Set<String> tags;
    private String title;
    private UUID id;
    private LocalDateTime timestamp;

    public Conversation(@JsonProperty("title") String title) {
        this.title = title;
        this.id = UUID.randomUUID();
        timestamp = LocalDateTime.now();
    }
}


