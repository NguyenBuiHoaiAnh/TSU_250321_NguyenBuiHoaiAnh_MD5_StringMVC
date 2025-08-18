package ra.edu.repo.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.model.entity.Appointment;
import ra.edu.repo.AppointmentRepo;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class AppointmentRepoImpl implements AppointmentRepo {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Appointment> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Appointment").list();
        return list;
    }


    // kiểm tra bác sĩ đã có lịch ở ngày + giờ đó chưa
    @Override
    public boolean existsByDoctorAndDateAndHour(Long doctorId, LocalDate date, Time hour) {
        Session session = sessionFactory.getCurrentSession();
        Long count = session.createQuery(
                        "select count(a) from Appointment a " +
                        "where a.doctor.id = :doctorId and a.date = :date and a.hour = :hour",
                        Long.class)
                .setParameter("doctorId", doctorId)
                .setParameter("date", date)
                .setParameter("hour", hour)
                .uniqueResult();
        return count != null && count > 0;
    }


    // Add
    @Override
    public boolean save(Appointment appointment) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(appointment);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Appointment findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Appointment.class, id);
    }

    @Override
    public boolean update(Appointment appointment) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.merge(appointment);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {

        try {
            Session session = sessionFactory.getCurrentSession();
            int i = session.createQuery("delete from Appointment where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();

            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
