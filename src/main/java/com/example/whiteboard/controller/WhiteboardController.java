package com.example.whiteboard.controller;

import com.example.whiteboard.service.DrawEventService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WhiteboardController {

    private final DrawEventService service;

    public WhiteboardController(DrawEventService service) {
        this.service = service;
    }

    @MessageMapping("/draw")
    @SendTo("/topic/whiteboard")
    public Map<String, Object> handleDraw(Map<String, Object> point) {

        int x = (int) point.get("x");
        int y = (int) point.get("y");

        service.saveEvent(x, y);

        return point;
    }
}
