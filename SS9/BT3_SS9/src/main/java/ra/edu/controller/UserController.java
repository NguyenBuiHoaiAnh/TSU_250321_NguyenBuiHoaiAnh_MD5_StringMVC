package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.model.User;

@Controller
@RequestMapping
public class UserController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("user") User user,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if ("username".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            user.setId((int) System.currentTimeMillis());
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/result";
        } else {
            model.addAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "register";
        }
    }

    @GetMapping("/result")
    public String showResult() {
        return "result";
    }

}