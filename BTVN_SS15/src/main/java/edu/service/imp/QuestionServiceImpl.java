package edu.service.imp;

import edu.model.entity.Question;
import edu.repo.QuestionRepo;
import edu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Question> findAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRepo.findById(id).orElse(null);
    }

    @Override
    public Question save(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public void delete(Question question) {
        questionRepo.delete(question);
    }
}
