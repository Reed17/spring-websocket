package net.gvvinblade.edu.springwebsocket.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessage(String destination, Object payload){
        template.convertAndSend(destination, payload);
    }

    public void sendToUser(String user, String destination, Object payload){
        template.convertAndSendToUser(user, destination, payload);
    }
}
