package ra.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.edu.model.Employee;
import ra.edu.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ModelAndView showEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView mv = new ModelAndView("listEmployee");
        mv.addObject("employees", employees);
        return mv;
    }

    @GetMapping("/employees/add")
    public String showEmployee() {
        return "addEmployee";
    }

    @PostMapping("/employees")
    public ModelAndView addEmployee(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String position = req.getParameter("position");

        Employee employee = new Employee(name, email, position);
        employeeService.addEmployee(employee);

        ModelAndView mv = new ModelAndView("redirect:/employees");
        return mv;
    }

}