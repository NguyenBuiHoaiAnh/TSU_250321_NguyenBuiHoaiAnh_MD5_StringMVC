package com.example.bt16_ss3.dao.imp;

import com.example.bt16_ss3.dao.StudentDAO;
import com.example.bt16_ss3.model.Student;
import com.example.bt16_ss3.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO {

    // Display Student
    @Override
    public List<Student> displayAllStudents() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> studentsList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_all_student()}");
            ResultSet rs = callSt.executeQuery();
            studentsList = new ArrayList<>();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                studentsList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return studentsList;
    }


    // Add Student
    @Override
    public boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_student(?,?,?)}");
            callSt.setString(1, student.getName());
            callSt.setInt(2, student.getAge());
            callSt.setString(3, student.getAddress());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }


    // Update Student
    @Override
    public Student findStudentById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            callSt.setInt(1, student.getId());
            callSt.setString(2, student.getName());
            callSt.setInt(3, student.getAge());
            callSt.setString(4, student.getAddress());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }


    // Delete Student
    @Override
    public boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

}
