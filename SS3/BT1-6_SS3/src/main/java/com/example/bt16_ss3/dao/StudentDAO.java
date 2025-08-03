package com.example.bt16_ss3.dao;

import com.example.bt16_ss3.model.Student;

import java.util.List;

public interface StudentDAO {
    // Display Student
    List<Student> displayAllStudents();

    // Add Student
    boolean addStudent(Student student);

    // Fix Student
    Student findStudentById(int id);

    boolean updateStudent(Student student);

    // Delete Student
    boolean deleteStudent(int id);

}
