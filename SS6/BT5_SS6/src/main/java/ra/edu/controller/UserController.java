package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.edu.model.User;
import ra.edu.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView showUsers(){
        List<User> userList = userService.getAllUsers();
        ModelAndView mv = new ModelAndView("userList");
        mv.addObject("users",userList);
        return mv;
    }
}