package com.imooc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(type = {"com.imooc.web.config.WebSocketConfiguration"})
public class WebsocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    public <T> void broadcast(BroadcastMessage<T> message) {
        messagingTemplate.convertAndSend(message.getDestinationPath(), message.getContent());
    }

    public <T> void pointToPoint(PointToPointMessage<T> message) {
        messagingTemplate.convertAndSendToUser(message.getUsername(), message.getDestinationPath(), message.getContent());
    }
}
