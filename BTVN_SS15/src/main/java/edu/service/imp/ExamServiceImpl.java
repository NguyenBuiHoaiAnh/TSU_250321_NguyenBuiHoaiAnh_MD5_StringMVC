package edu.service.imp;

import edu.model.entity.Exam;
import edu.repo.ExamRepo;
import edu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepo examRepo;

    @Override
    public List<Exam> findAll() {
        return examRepo.findAll();
    }

    @Override
    public Exam findById(Long id) {
        return examRepo.findById(id).orElse(null);
    }

    @Override
    public Exam save(Exam exam) {
        return examRepo.save(exam);
    }

    @Override
    public void delete(Exam exam) {
        examRepo.delete(exam);
    }
}
