package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Student;
import ra.edu.repo.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public boolean addStudent(Student student) {
        return studentRepo.addStudent(student);
    }

    public Student findStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    public boolean updateStudent(Student student) {
        return studentRepo.updateStudent(student);
    }

    public boolean deleteStudent(int id) {
        return studentRepo.deleteStudent(id);
    }
}
