package edu.controller;

import edu.model.dto.CustomerLogin;
import edu.model.entity.Customer;
import edu.service.CustomerService;
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

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String login(Model model) {
        CustomerLogin customerLogin = new CustomerLogin();
        model.addAttribute("customerLogin", customerLogin);
        return "customer/login";
    }

    @PostMapping("/login")
    public String checkLogin(@Valid @ModelAttribute("customerLogin") CustomerLogin customerLogin,
                             BindingResult rs, Model model, HttpSession session) {
        if (rs.hasErrors()) {
            return "customer/login";
        }

        String password = customerLogin.getPassword();
        String userName = customerLogin.getUsername();
        Customer customer = customerService.login(userName, password);
        if (customer != null) {
            session.setAttribute("user", customer);
            if (customer.getRole().name().equals("ADMIN")) {
                model.addAttribute("success", "Login Admin Success");
                return "user/admin";
            } else {
                model.addAttribute("success", "Login User Success");
                return "user/user";
            }
        } else {
            model.addAttribute("error", "Login Fail");
            return "customer/login";
        }
    }

    @GetMapping("/registers")
    public String registers(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/register";
    }

    @PostMapping("/registers")
    public String checkRegister(@Valid @ModelAttribute("customer") Customer customer,
                                BindingResult rs, Model model) {
        if (rs.hasErrors()) {
            return "customer/register";
        } else {
            if (customerService.checkUsernameExisted(customer.getUsername())) {
                rs.rejectValue("username", null, "Username đã tồn tại");
                return "customer/register";
            }
            if (!customerService.checkComfirmPassword(customer.getPassword(), customer.getConfirmPassword())) {
                rs.rejectValue("password", null, "Confirm password không trùng với password");
                return "customer/register";
            }
            if (customerService.checkEmailExisted(customer.getEmail())) {
                rs.rejectValue("email", null, "Email đã tồn tại");
                return "customer/register";
            }
            if (customerService.checkPhoneExisted(customer.getPhone())) {
                rs.rejectValue("phone", null, "Phone đã tồn tại");
                return "customer/register";
            }
        }

        Customer customer1 = customerService.registerCustomer(customer);
        if (customer1 != null) {
            model.addAttribute("customerLogin", new CustomerLogin());
            return "customer/login";
        } else {
            model.addAttribute("error", "Register Fail");
            return "customer/register";
        }

    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "user/admin";
    }
}

