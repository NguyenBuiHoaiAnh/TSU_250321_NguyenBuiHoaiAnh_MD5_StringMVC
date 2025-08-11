package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.model.User;

@Controller
@RequestMapping(value = {"/", "home"})
public class UserController {

    @GetMapping
    public String initInsertStudent(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "insertUser";
    }

    @PostMapping("/insert-user")
    public String insertUser(@Valid @ModelAttribute("user") User user,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "insertUser";
        } else {
            model.addAttribute("user", user);
            return "viewUser";
        }
    }
}