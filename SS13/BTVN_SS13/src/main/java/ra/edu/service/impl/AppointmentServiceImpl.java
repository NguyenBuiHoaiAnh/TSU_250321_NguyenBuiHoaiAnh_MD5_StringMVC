package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.entity.Appointment;
import ra.edu.repo.AppointmentRepo;
import ra.edu.service.AppointmentService;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public List<Appointment> displayAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public boolean existsByDoctorAndDateAndHour(Long doctorId, LocalDate date, Time hour) {
        return appointmentRepo.existsByDoctorAndDateAndHour(doctorId, date, hour);
    }

    @Override
    public boolean addAppointment(Appointment appointment) {
        if (existsByDoctorAndDateAndHour(
                appointment.getDoctor().getId(),
                appointment.getDate(),
                appointment.getHour()
        )) {
            return false;
        }
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment findAppointmentById(int appointmentId) {
        return appointmentRepo.findById(appointmentId);
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        if (existsByDoctorAndDateAndHour(
                appointment.getDoctor().getId(),
                appointment.getDate(),
                appointment.getHour()
        )) {
            return false;
        }
        return appointmentRepo.update(appointment);
    }

    @Override
    public boolean deleteAppointmentById(int appointmentId) {
        return appointmentRepo.deleteById(appointmentId);
    }
}
