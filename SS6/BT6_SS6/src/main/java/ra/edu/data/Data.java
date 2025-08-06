package ra.edu.data;

import ra.edu.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Employee> employeesList = new ArrayList<>();

    static {
        employeesList.add(new Employee("Nguyễn Văn A", "a@gmail.com", "Quản lý"));
        employeesList.add(new Employee("Trần Thị B", "b@gmail.com", "Kế toán"));
        employeesList.add(new Employee("Lê Văn C", "c@gmail.com", "Nhân sự"));
    }
}
