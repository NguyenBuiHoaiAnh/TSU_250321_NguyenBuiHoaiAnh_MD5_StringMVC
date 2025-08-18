package ra.edu.repo;

import ra.edu.model.entity.Patient;

import java.util.List;

public interface PatientRepo {

    List<Patient> findAll();

    boolean save(Patient patient);

    Patient findById(int id);

    boolean update(Patient patient);

    boolean delete(int id);

    void changeStatus(int id);
}
