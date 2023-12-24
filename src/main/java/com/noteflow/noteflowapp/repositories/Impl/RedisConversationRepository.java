package com.noteflow.noteflowapp.repositories.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.repositories.ConversationRepository;
import com.noteflow.noteflowapp.util.RedisConnectionUtil;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisConversationRepository implements ConversationRepository {

    RedisConnectionUtil redisConnectionUtil;
    ObjectMapper objectMapper;

    //constructor injection is the preferred method for spring DI
    public RedisConversationRepository(RedisConnectionUtil redisConnectionUtil) {
        this.redisConnectionUtil = redisConnectionUtil;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public <S extends Conversation> S save(S entity) {
        String entityID = entity.getId().toString();
        try {
            // convert the Conversation object to a json string
            String json = objectMapper.writeValueAsString(entity);
            // write the data to the redis cache
            redisConnectionUtil.write(entityID, json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public <S extends Conversation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Conversation> findById(String id) {
        try {
            // retrieve json representation of object from redis cache, which may or may not exist
            String json = redisConnectionUtil.read(id);

            if (json == null) {
                return Optional.empty();
            }

            // convert non-null json representation of the object into a Conversation object
            Optional<Conversation> conversation = Optional.of(objectMapper.readValue(json, Conversation.class));
            return conversation;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Conversation> findAll() {
        return null;
    }

    @Override
    public Iterable<Conversation> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {
        redisConnectionUtil.delete(s);
    }

    @Override
    public void delete(Conversation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Conversation> entities) {

    }

    @Override
    public void deleteAll() {

    }


}
