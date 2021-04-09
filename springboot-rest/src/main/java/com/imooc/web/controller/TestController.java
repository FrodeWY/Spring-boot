package com.imooc.web.controller;

import com.imooc.web.config.BroadcastMessage;
import com.imooc.web.config.PointToPointMessage;
import com.imooc.web.config.WebsocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/test/")
public class TestController {
    @Autowired
    private WebsocketService drpWebsocketService;

    @PostMapping("broadcast")
    private void broadcast(BroadcastMessage<String> message) {
        drpWebsocketService.broadcast(message);
    }

    @PostMapping("pointToPoint")
    private void pointToPoint(PointToPointMessage<String> message) {
        drpWebsocketService.pointToPoint(message);
    }
}
