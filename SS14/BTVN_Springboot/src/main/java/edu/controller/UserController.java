package edu.controller;

import edu.model.dto.LoginDto;
import edu.model.entity.User;
import edu.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String login(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login/login";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
                        BindingResult rs,
                        Model model) {
        if (rs.hasErrors()) {
            return "login/login";
        }

        User user = userService.findByUserNameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (user != null) {
            if (user.getRole().name().equals("ADMIN")) {
                model.addAttribute("success", "Login Admin Success");
                return "login/admin";
            } else {
                model.addAttribute("success", "Login Admin Success");
                return "login/user";
            }
        } else {
            model.addAttribute("error", "Login Fail");
            return "login/login";
        }
    }

    @GetMapping("/admin")
    public String admin() {
        return "login/admin";
    }
}
