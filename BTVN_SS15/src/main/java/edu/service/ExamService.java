package edu.service;

import edu.model.entity.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> findAll();

    Exam findById(Long id);

    Exam save(Exam exam);

    void delete(Exam exam);
}
