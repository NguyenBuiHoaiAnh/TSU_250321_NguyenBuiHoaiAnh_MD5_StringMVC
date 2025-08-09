package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/submit")
    public String processForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "result";
    }
}