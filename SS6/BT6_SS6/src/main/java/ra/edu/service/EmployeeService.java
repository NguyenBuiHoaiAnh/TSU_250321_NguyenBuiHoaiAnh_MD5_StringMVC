package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Employee;
import ra.edu.repo.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.getAllEmployees();
    }

    public void addEmployee(Employee employee){
        employeeRepo.addEmployee(employee);
    }
}
