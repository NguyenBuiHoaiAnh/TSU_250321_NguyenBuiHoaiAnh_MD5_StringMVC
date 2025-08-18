package ra.edu.service;

import ra.edu.model.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();

    boolean addPatient(Patient patient);

    Patient findById(int id);

    boolean updatePatient(Patient patient);

    boolean deletePatient(int id);

    void changeStatus(int id);
}
