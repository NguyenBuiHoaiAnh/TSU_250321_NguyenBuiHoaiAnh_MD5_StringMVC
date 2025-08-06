package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.model.User;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String showForm() {
        return "registration"; // show form
    }

    @PostMapping("/register")
    public String handleRegistration(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            Model model) {

        boolean hasError = false;

        if (username == null || username.trim().isEmpty()) {
            model.addAttribute("usernameError", "Tên không được để trống");
            hasError = true;
        }

        if (email == null || email.trim().isEmpty()) {
            model.addAttribute("emailError", "Email không được để trống");
            hasError = true;
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            model.addAttribute("emailError", "Email không hợp lệ");
            hasError = true;
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            model.addAttribute("phoneError", "Số điện thoại không được để trống");
            hasError = true;
        } else if (!phoneNumber.matches("^(0|\\+84)[35789]\\d{8}$")) {
            model.addAttribute("phoneError", "Số điện thoại Việt Nam không hợp lệ");
            hasError = true;
        }

        if (hasError) {
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("phoneNumber", phoneNumber);
            return "registration";
        }

        // Nếu hợp lệ
        User user = new User(username, email, phoneNumber);
        model.addAttribute("user", user);
        return "result";
    }
}