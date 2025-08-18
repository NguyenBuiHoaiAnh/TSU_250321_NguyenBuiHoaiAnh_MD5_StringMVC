package ra.edu.repo.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.model.entity.Doctor;
import ra.edu.repo.DoctorRepo;

import java.util.List;

@Repository
@Transactional
public class DoctorRepoImpl implements DoctorRepo {

    @Autowired
    private SessionFactory sessionFactory;

    // List
    @Override
    public List<Doctor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Doctor").list();
        return list;
    }

    // Add
    @Override
    public boolean save(Doctor doctor) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(doctor);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update
    @Override
    public Doctor findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Doctor.class, id);
    }

    @Override
    public boolean update(Doctor doctor) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.merge(doctor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete
    @Override
    public boolean deleteById(int id) {

        try {
            Session session = sessionFactory.getCurrentSession();
            int i = session.createQuery("delete from Doctor where id =:id")
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

    @Override
    public void changeStatus(int id) {
        Doctor doctor = findById(id);
        doctor.setStatus(!doctor.getStatus());
        update(doctor);
    }
}
