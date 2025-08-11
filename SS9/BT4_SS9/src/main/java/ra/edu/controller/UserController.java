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

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/")
public class UserController {

    private AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("user") User user,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        } else {
            user.setId(idGenerator.getAndIncrement());
            model.addAttribute("user", user);
            return "result";
        }
    }
}