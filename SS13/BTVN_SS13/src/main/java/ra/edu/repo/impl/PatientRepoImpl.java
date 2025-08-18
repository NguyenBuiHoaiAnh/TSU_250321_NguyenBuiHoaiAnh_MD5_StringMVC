package ra.edu.repo.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.model.entity.Patient;
import ra.edu.repo.PatientRepo;

import java.util.List;

@Repository
@Transactional
public class PatientRepoImpl implements PatientRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Patient> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Patient").list();
        return list;
    }

    @Override
    public boolean save(Patient patient) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(patient);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Patient findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Patient.class, id);
    }

    @Override
    public boolean update(Patient patient) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.merge(patient);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            int i = session.createQuery("delete from Patient p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void changeStatus(int id) {
        Patient patient = findById(id);
        patient.setStatus(!patient.getStatus());
        update(patient);
    }
}
