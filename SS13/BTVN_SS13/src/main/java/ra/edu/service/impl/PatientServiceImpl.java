package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.entity.Patient;
import ra.edu.repo.PatientRepo;
import ra.edu.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Override
    public boolean addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient findById(int id) {
        return patientRepo.findById(id);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return patientRepo.update(patient);
    }

    @Override
    public boolean deletePatient(int id) {
        return patientRepo.delete(id);
    }

    @Override
    public void changeStatus(int id) {
        patientRepo.changeStatus(id);
    }
}
