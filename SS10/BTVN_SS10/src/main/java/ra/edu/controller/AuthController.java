package ra.edu.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.model.Customer;
import ra.edu.model.dto.LoginDTO;
import ra.edu.service.CustomerService;

@Controller
@RequestMapping(value = {"/", "/auth"})
public class AuthController {
    @Autowired
    private CustomerService customerService;

    // Register
    @GetMapping(value = {"/register"})
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping(value = {"/register"})
    public String registerCustomerProcess(@Valid @ModelAttribute("customer") Customer customer,
                                          BindingResult rs, Model model) {
        if (rs.hasErrors()) {
            model.addAttribute("customer", customer);
            return "register";
        }

        boolean result = customerService.registerCustomer(customer);
        if (result) {
            return "login";
        } else {
            model.addAttribute("err", "Register failed!");
            return "register";
        }
    }


    // Login
    @GetMapping(value = {"/", "/login"})
    public String login(Model model) {
        model.addAttribute("dtoLogin", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String loginCustomerProcess(@Valid @ModelAttribute("dtoLogin") LoginDTO dtoLogin,
                                       BindingResult rs, Model model, HttpSession session) {
        if (rs.hasErrors()) {
            model.addAttribute("err", "Customer not found!");
            model.addAttribute("dtoLogin", dtoLogin);
            return "login";
        }

        Customer customer = customerService.getCustomer(dtoLogin);
        if (customer != null) {
            session.setAttribute("customer", customer);
            switch (customer.getRole()) {
                case "ADMIN":
                    return "home_admin";
                case "USER":
                    return "home_user";
            }
            return "";
        } else {
            model.addAttribute("err", "Customer not found!");
            model.addAttribute("dtoLogin", dtoLogin);
            return "login";
        }
    }
}