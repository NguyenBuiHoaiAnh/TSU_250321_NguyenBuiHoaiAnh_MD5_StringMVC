package ra.edu.service;

import ra.edu.model.Message;

import java.util.List;

public interface MessageService {
    void sendMessage(Message message);

    List<Message> getMessage(Long senderId, Long receiverId);
}
