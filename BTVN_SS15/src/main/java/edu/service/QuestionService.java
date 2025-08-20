package edu.service;

import edu.model.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question findById(Long id);

    Question save(Question question);

    void delete(Question question);

}
