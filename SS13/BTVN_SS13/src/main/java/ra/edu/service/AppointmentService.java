package ra.edu.service;

import ra.edu.model.entity.Appointment;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<Appointment> displayAllAppointments();

    boolean existsByDoctorAndDateAndHour(Long doctorId, LocalDate date, Time hour);

    boolean addAppointment(Appointment appointment);

    Appointment findAppointmentById(int appointmentId);

    boolean updateAppointment(Appointment appointment);

    boolean deleteAppointmentById(int appointmentId);
}
