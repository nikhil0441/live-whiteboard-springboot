package com.example.whiteboard.repository;

import com.example.whiteboard.model.DrawEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawEventRepository extends JpaRepository<DrawEvent, Long> {
}
