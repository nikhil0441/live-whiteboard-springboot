package com.example.whiteboard.service;

import com.example.whiteboard.model.DrawEvent;
import com.example.whiteboard.repository.DrawEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DrawEventService {

    private final DrawEventRepository repository;

    public DrawEventService(DrawEventRepository repository) {
        this.repository = repository;
    }

    public DrawEvent saveEvent(int x, int y) {
        DrawEvent event = new DrawEvent();
        event.setX(x);
        event.setY(y);
        event.setCreatedAt(LocalDateTime.now());

        return repository.save(event);
    }

    public List<DrawEvent> getAllEvents() {
        return repository.findAll();
    }

    public void clearBoard() {
        repository.deleteAll();
    }
}
