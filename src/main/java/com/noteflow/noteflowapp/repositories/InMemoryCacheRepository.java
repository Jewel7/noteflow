package com.noteflow.noteflowapp.repositories;

import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.models.Question;
import com.noteflow.noteflowapp.models.Response;

import java.util.Set;


/**
 * Store the data in RAM.
 */
public class InMemoryCacheRepository implements Repository {

    @Override
    public Conversation createConversation() {
        return null;
    }

    @Override
    public Question createQuestion() {
        return null;
    }

    @Override
    public Response createResponse() {
        return null;
    }

    @Override
    public Set<Conversation> getConversations() {
        return null;
    }

    @Override
    public Conversation getConversation() {
        return null;
    }

    @Override
    public Set<Question> getQuestions() {
        return null;
    }

    @Override
    public Question getQuestion() {
        return null;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public Conversation editConversation() {
        return null;
    }

    @Override
    public Question editQuestion() {
        return null;
    }

    @Override
    public void deleteConversations() {

    }

    @Override
    public void deleteConversation() {

    }

    @Override
    public void deleteQuestions() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void deleteResponses() {

    }

    @Override
    public void deleteResponse() {

    }
}
