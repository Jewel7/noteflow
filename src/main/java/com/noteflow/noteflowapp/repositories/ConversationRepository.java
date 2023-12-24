package com.noteflow.noteflowapp.repositories;

import com.noteflow.noteflowapp.models.Conversation;
import org.springframework.data.repository.CrudRepository;


public interface ConversationRepository extends CrudRepository<Conversation, String> {
}
