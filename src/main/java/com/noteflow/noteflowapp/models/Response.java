package com.noteflow.noteflowapp.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class Response {
    UUID id;
    Set<String> urlLinks;
    private String text;
    private LocalDateTime timestamp;

    public Response(String text) {
        this.text = text;
        timestamp = LocalDateTime.now();
    }

    public Response(String text, UUID id) {
        this.id = id;
        timestamp = LocalDateTime.now();
    }
}
