package ra.edu.repo;

import ra.edu.model.entity.Appointment;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepo {

    List<Appointment> findAll();

    boolean existsByDoctorAndDateAndHour(Long doctorId, LocalDate date, Time hour);

    // Add
    boolean save(Appointment appointment);

    Appointment findById(int id);

    boolean update(Appointment appointment);

    boolean deleteById(int id);


}
