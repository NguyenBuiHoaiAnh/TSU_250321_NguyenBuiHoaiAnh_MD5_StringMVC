package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ra.edu.model.Message;
import ra.edu.model.User;
import ra.edu.service.MessageService;
import ra.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/sender/{senderId}/receiver/{receiverId}")
    public String showMessages(@PathVariable("senderId") Long senderId,
                               @PathVariable("receiverId") Long receiverId,
                               Model model) {
        List<Message> messageList = messageService.getMessage(senderId, receiverId);
        model.addAttribute("messages", messageList);
        model.addAttribute("senderId", senderId);
        model.addAttribute("receiverId", receiverId);
        model.addAttribute("newMessage", new Message());
        return "message";
    }

    @PostMapping("/sender/{senderId}/receiver/{receiverId}")
    public String sendMessage(@PathVariable("senderId") Long senderId,
                              @PathVariable("receiverId") Long receiverId,
                              @ModelAttribute("newMessage") Message message) {
        User sender = userService.findById(senderId);
        User receiver = userService.findById(receiverId);

        message.setSender(sender);
        message.setReceiver(receiver);

        messageService.sendMessage(message);
        return "redirect:/messages/sender/" + senderId + "/receiver/" + receiverId;
    }
}