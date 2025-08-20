package edu.controller;

import edu.model.entity.Exam;
import edu.model.entity.Question;
import edu.service.ExamService;
import edu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;

    @GetMapping
    public String question(Model model) {
        List<Question> questionsList = questionService.findAll();
        model.addAttribute("questionsList",questionsList);
        return "question/listQuestion";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Exam> examsList = examService.findAll();
        Question question = new Question();
        model.addAttribute("question", question);
        model.addAttribute("exams",examsList);
        return "question/addQuestion";
    }

    @PostMapping("/add")
    public String addExam(@ModelAttribute("question") Question question,
                          Model model) {
        Question question1 = questionService.save(question);

        if (question1 != null) {
            return "redirect:/questions";
        } else {
            model.addAttribute("exams", examService.findAll());
            model.addAttribute("error","Insert failed!");
            return "question/listQuestion";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Question question = questionService.findById(id);
        List<Exam> examsList = examService.findAll();
        model.addAttribute("exams",examsList);
        model.addAttribute("question", question);
        return "question/editQuestion";
    }

    // Xử lý sửa
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("question") Question question,
                              Model model) {
        Question question1 = questionService.save(question);

        if (question1 != null) {
            return "redirect:/questions";
        } else {
            model.addAttribute("exams", examService.findAll());
            model.addAttribute("error","Insert failed!");
            return "question/editQuestion";
        }
    }

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        Question question = questionService.findById(id);
        questionService.delete(question);
        return "redirect:/questions";
    }
}
