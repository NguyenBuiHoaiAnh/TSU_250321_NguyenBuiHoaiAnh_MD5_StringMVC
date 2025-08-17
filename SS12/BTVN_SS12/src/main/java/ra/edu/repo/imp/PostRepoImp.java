package ra.edu.repo.imp;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.model.Post;
import ra.edu.repo.PostRepo;

import java.util.List;

@Repository
@Transactional
public class PostRepoImp implements PostRepo {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Post> findAllPost(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Post> query = session.createQuery("from Post p where p.user.id = :userId or p.friend.id = :userId" +
                                                " order by p.createdDate desc ", Post.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void save(Post post) {
        sessionFactory.getCurrentSession().persist(post);
    }

    @Override
    public Post findById(Long id) {
        return sessionFactory.getCurrentSession().find(Post.class, id);
    }

    @Override
    public void delete(Long id) {
        Post post = findById(id);
        if (post != null) {
            sessionFactory.getCurrentSession().remove(post);
        }
    }
}