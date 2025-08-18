package ra.edu.repo;

import ra.edu.model.entity.Doctor;

import java.util.List;

public interface DoctorRepo {
    // List
    List<Doctor> findAll();

    // Add
    boolean save(Doctor doctor);

    // Update
    Doctor findById(int id);
    boolean update(Doctor doctor);

    // Delete
    boolean deleteById(int id);
    void changeStatus(int id);
}
