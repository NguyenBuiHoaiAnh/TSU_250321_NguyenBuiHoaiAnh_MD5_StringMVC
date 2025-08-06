package ra.edu.repo;

import org.springframework.stereotype.Repository;
import ra.edu.data.Data;
import ra.edu.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepo {
    public List<Employee> getAllEmployees() {
        return Data.employeesList;
    }

    public void addEmployee(Employee employee) {
        Data.employeesList.add(employee);
    }
}
