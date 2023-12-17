package com.noteflow.noteflowapp.models;

import lombok.Data;

import java.util.Set;

@Data
public class Question {

    private Set<Response> responses;
    private String text;

    public Question(String text, Set<Response> responses) {
        this.text = text;
        this.responses = responses;
    }

}
