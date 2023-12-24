package com.noteflow.noteflowapp.repositories.Impl;

import com.noteflow.noteflowapp.models.Question;
import com.noteflow.noteflowapp.repositories.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisQuestionRepository implements QuestionRepository {
    @Override
    public <S extends Question> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Question> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Question> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Question> findAll() {
        return null;
    }

    @Override
    public Iterable<Question> findAllById(Iterable<Integer> integers) {
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
    public void delete(Question entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Question> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
