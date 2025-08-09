package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.model.Student;
import ra.edu.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping
    public String findAll(Model model) {
        List<Student> studentsList = studentService.findAll();
        model.addAttribute("studentsList", studentsList);

        studentsList.forEach(System.out::println);

        return "studentList"; // này là trang jsp
    }

    // Hiển thị form add sinh viên
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    // Xử lý submit form
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        boolean result = studentService.addStudent(student);

        if (result) {
            return "redirect:/student";
        }  else {
            return "error";
        }
    }

    // Edit
    @GetMapping("/editStudent")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "editStudent"; // Tên file JSP
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute("student") Student student) {

        boolean result = studentService.updateStudent(student);
        if (result) {
            return "redirect:/student";
        } else {
            return "error";
        }
    }

    // Delete
    @GetMapping("/deleteStudent")
    public String delete(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }


}