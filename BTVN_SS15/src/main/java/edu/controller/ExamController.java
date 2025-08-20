package edu.controller;

import edu.model.entity.Exam;
import edu.service.ExamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping
    public String listExam(Model model) {
        List<Exam> exams = examService.findAll();
        model.addAttribute("exams", exams);
        return "exam/listExam";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Exam exams = new Exam();
        model.addAttribute("exams", exams);
        return "exam/addExam";
    }

    @PostMapping("/add")
    public String addExam(@ModelAttribute("exams") Exam exams,
                          Model model) {
        Exam exam = examService.save(exams);

        if (exam != null) {
            return "redirect:/exams";
        } else {
            model.addAttribute("error","Insert failed!");
            return "exam/addExam";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Exam exam = examService.findById(id);
        model.addAttribute("exam", exam);
        return "exam/editExam";
    }

    // Xử lý sửa
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("exam") Exam exam,
                              Model model) {
        Exam exams = examService.save(exam);

        if (exams != null) {
            return "redirect:/exams";
        } else {
            model.addAttribute("error","Insert failed!");
            return "exam/editExam";
        }
    }

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        Exam exam = examService.findById(id);
        examService.delete(exam);
        return "redirect:/exams";
    }
}
