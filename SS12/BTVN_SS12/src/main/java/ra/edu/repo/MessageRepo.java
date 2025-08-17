package ra.edu.repo;

import ra.edu.model.Message;

import java.util.List;

public interface MessageRepo {

    void save(Message message);

    List<Message> getMessage(Long senderId, Long receiverId);
}
