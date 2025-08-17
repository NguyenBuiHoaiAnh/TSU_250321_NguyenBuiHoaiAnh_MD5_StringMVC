package ra.edu.repo.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.edu.model.User;
import ra.edu.repo.UserRepo;

import java.util.List;

@Repository
@Transactional
public class UserRepoImp implements UserRepo {

    private final SessionFactory sessionFactory;

    public UserRepoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }


    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where id = :id", User.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public User findByEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .list();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    @Override
    public List<User> findAllFriend(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select f from User u join u.friends f where u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
    }
}
