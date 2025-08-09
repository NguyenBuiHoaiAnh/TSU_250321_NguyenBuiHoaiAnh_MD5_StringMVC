package ra.edu.repo;

import org.springframework.stereotype.Repository;
import ra.edu.model.Student;
import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    // Display
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> studentsList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_student()}");
            ResultSet rs = callSt.executeQuery();
            studentsList = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob").toLocalDate());
                studentsList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return studentsList;
    }

    // Add
    public boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_student(?,?,?)}");
            callSt.setString(1, student.getName());
            callSt.setString(2, student.getEmail());
            callSt.setDate(3, java.sql.Date.valueOf(student.getDob()));
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Update
    public Student getStudentById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    public boolean updateStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            callSt.setInt(1, student.getId());
            callSt.setString(2, student.getName());
            callSt.setString(3, student.getEmail());
            callSt.setDate(4, java.sql.Date.valueOf(student.getDob()));
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Delete
    public boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
