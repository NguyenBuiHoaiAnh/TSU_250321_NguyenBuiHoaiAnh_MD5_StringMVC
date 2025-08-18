package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.entity.Doctor;
import ra.edu.repo.DoctorRepo;
import ra.edu.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        doctor.setStatus(true);
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor findById(int id) {
        return doctorRepo.findById(id);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return doctorRepo.update(doctor);
    }

    @Override
    public boolean deleteDoctor(int id) {
        return doctorRepo.deleteById(id);
    }

    @Override
    public void changeStatus(int id) {
        doctorRepo.changeStatus(id);
    }
}
