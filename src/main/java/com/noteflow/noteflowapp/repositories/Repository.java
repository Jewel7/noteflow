package com.noteflow.noteflowapp.repositories;

import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.models.Question;
import com.noteflow.noteflowapp.models.Response;

import java.util.Set;

/**
 * CRUD Interface that contains methods on how to interact with the data store.
 * This is not part of the controller.
 */
public interface Repository {

    // --- CREATE DATA ---
//    User createUser();

    Conversation createConversation();

    Question createQuestion();

    Response createResponse();

    // --- READ DATA ---

    /**
     * Retrieves a set of Conversation objects representing the ongoing conversations for a user.
     * Use case: user logged in to their profile and gets all their conversations.
     *
     * @return A Set containing Conversation objects that represent the current ongoing conversations for a user.
     */
    Set<Conversation> getConversations();


    /**
     * Retrieves a Conversation object representing an ongoing conversation for a user.
     * Use case: user logged in to their profile and searches for a specific conversation.
     *
     * @return A Conversation object that represents a current ongoing conversations for a user.
     */
    Conversation getConversation();

    // use case: user wants to see all their questions posted to a conversation
    Set<Question> getQuestions();

    Question getQuestion();

    // use case: user logs in
    String getUser();


    // --- UPDATE DATA ---
    Conversation editConversation();

    Question editQuestion();

    //--- DELETE DATA ---
    void deleteConversations();

    void deleteConversation();

    void deleteQuestions();

    void deleteQuestion();

    void deleteUser();

    void deleteResponses();

    void deleteResponse();


//    TODO: determine if I need these?
//    Response getResponse();
//    Set<Response> getResponses();
//    UUID getResponseID();
}
