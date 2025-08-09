package ra.edu.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.edu.model.User;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") @Valid User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "registerForm";
        }

        // Xử lý logic đăng ký ở đây, ví dụ lưu vào DB
        return "registerSuccess"; // Trang hiển thị khi đăng ký thành công
    }
}