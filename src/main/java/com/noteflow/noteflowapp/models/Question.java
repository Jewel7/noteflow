package com.noteflow.noteflowapp.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class Question {

    private UUID id;
    private String title;
    // responses can be empty
    private Set<Response> responses;
    // if there is at least one response, set to true. Default is false
    private Boolean isAnswered = false;
    private LocalDateTime timestamp;

    public Question(String title, Set<Response> responses) {
        this.title = title;
        this.responses = responses;
    }

}
