package ra.edu.repo.imp;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.model.Message;
import ra.edu.repo.MessageRepo;

import java.util.List;

@Repository
@Transactional
public class MessageRepoImp implements MessageRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Message message) {
        sessionFactory.getCurrentSession().persist(message);
    }

    @Override
    public List<Message> getMessage(Long senderId, Long receiverId) {
        return sessionFactory.getCurrentSession()
                .createQuery("select m from Message m " +
                             "where (m.sender.id = :senderId and m.receiver.id = :receiverId) " +
                             "or (m.sender.id = :receiverId and m.receiver.id = :senderId) " +
                             "order by m.sentDate asc", Message.class)
                .setParameter("senderId", senderId)
                .setParameter("receiverId", receiverId)
                .list();
    }
}
