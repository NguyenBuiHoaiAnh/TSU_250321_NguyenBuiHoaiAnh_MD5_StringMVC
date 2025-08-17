package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Message;
import ra.edu.repo.MessageRepo;
import ra.edu.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public void sendMessage(Message message) {
        messageRepo.save(message);
    }

    @Override
    public List<Message> getMessage(Long senderId, Long receiverId) {
        return messageRepo.getMessage(senderId, receiverId);
    }
}
