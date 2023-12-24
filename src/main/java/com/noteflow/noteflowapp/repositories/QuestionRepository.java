package com.noteflow.noteflowapp.repositories;

import com.noteflow.noteflowapp.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
