package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.model.Seed;
import ra.edu.model.User;
import ra.edu.model.UserLogin;
import ra.edu.service.GameService;

import java.util.List;

@Controller
public class GameController {
    private GameService gameService = new GameService();

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) throws Exception {
        boolean success = gameService.register(user);
        if (success) return "redirect:/login";
        model.addAttribute("error", "Username already exists!");
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) throws Exception {
        User user = gameService.login(username, password);
        if (user != null) {
            UserLogin.setUser(user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/shop")
    public String showShop(Model model) throws Exception {
        if (!UserLogin.isLoggedIn()) return "redirect:/login";
        List<Seed> seeds = gameService.getSeeds();
        model.addAttribute("seeds", seeds);
        return "/shop";
    }

    @GetMapping("/home")
    public String home() {
        return UserLogin.isLoggedIn() ? "home" : "redirect:/login";
    }
}