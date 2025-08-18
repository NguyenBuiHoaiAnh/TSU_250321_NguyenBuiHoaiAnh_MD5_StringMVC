package ra.edu.service;

import ra.edu.model.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();

    boolean addDoctor(Doctor doctor);

    Doctor findById(int id);

    boolean updateDoctor(Doctor doctor);

    boolean deleteDoctor(int id);

    void changeStatus(int id);

}
