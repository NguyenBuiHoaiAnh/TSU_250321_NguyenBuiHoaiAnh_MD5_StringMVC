package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/","home"})
public class HelloServlet {

    @GetMapping()
    public String home(Model model){

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(1, "Nguyễn Văn A", 20, "12A1", "vana@example.com", "Hà Nội", "0901234567"));
        studentsList.add(new Student(2, "Trần Thị B", 21, "12A2", "thib@example.com", "Hồ Chí Minh", "0912345678"));
        studentsList.add(new Student(3, "Lê Văn C", 19, "11B1", "vanc@example.com", "Đà Nẵng", "0923456789"));
        studentsList.add(new Student(4, "Phạm Thị D", 20, "12A3", "thid@example.com", "Cần Thơ", "0934567890"));
        studentsList.add(new Student(5, "Hoàng Văn E", 18, "10A1", "vane@example.com", "Hải Phòng", "0945678901"));
        studentsList.add(new Student(6, "Đỗ Thị F", 22, "12B1", "thif@example.com", "Nghệ An", "0956789012"));
        studentsList.add(new Student(7, "Ngô Văn G", 20, "11A2", "vang@example.com", "Quảng Ninh", "0967890123"));
        studentsList.add(new Student(8, "Bùi Thị H", 19, "10B2", "thih@example.com", "Bình Dương", "0978901234"));
        studentsList.add(new Student(9, "Phan Văn I", 21, "12C1", "vani@example.com", "Thanh Hóa", "0989012345"));
        studentsList.add(new Student(10, "Vũ Thị J", 20, "11C2", "thij@example.com", "Nam Định", "0990123456"));

        model.addAttribute("studentsList", studentsList);

        return "studentList";
    }
}