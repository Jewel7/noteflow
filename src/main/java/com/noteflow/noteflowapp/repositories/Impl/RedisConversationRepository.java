package com.noteflow.noteflowapp.repositories.Impl;

import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.repositories.ConversationRepository;
import com.noteflow.noteflowapp.util.RedisConnectionUtil;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisConversationRepository implements ConversationRepository {

    RedisConnectionUtil redisConnectionUtil;

    //constructor injection is the preferred method for spring DI
    public RedisConversationRepository(RedisConnectionUtil redisConnectionUtil) {
        this.redisConnectionUtil = redisConnectionUtil;
    }

    @Override
    public <S extends Conversation> S save(S entity) {
        String entityString = entity.toString();
        String entityID = entity.getId().toString();
        redisConnectionUtil.write(entityID, entityString);
        return null;
    }

    @Override
    public <S extends Conversation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Conversation> findById(String id) {
        redisConnectionUtil.read(id);
        return Optional.empty();
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
