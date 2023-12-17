package com.noteflow.noteflowapp.repositories.Impl;

import com.noteflow.noteflowapp.repositories.ResponseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisResponseRepository implements ResponseRepository {
    @Override
    public <S extends ResponseRepository> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ResponseRepository> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ResponseRepository> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<ResponseRepository> findAll() {
        return null;
    }

    @Override
    public Iterable<ResponseRepository> findAllById(Iterable<Integer> integers) {
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
    public void delete(ResponseRepository entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ResponseRepository> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
