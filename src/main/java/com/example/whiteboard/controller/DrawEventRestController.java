package com.example.whiteboard.controller;

import com.example.whiteboard.model.DrawEvent;
import com.example.whiteboard.service.DrawEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/draw-events")
public class DrawEventRestController {

    private final DrawEventService service;

    public DrawEventRestController(DrawEventService service) {
        this.service = service;
    }

    // 🔥 Load all dots from DB
    @GetMapping
    public List<DrawEvent> getAllEvents() {
        return service.getAllEvents();
    }
}
