package com.noteflow.noteflowapp.repositories.Impl;

import com.noteflow.noteflowapp.models.Conversation;
import com.noteflow.noteflowapp.repositories.ConversationRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisConversationRepository implements ConversationRepository {
    @Override
    public <S extends Conversation> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Conversation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Conversation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Conversation> findAll() {
        return null;
    }

    @Override
    public Iterable<Conversation> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Conversation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Conversation> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
