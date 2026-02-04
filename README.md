# Live Whiteboard Application

A real-time collaborative whiteboard application built using **Java Spring Boot**, **WebSockets**, **MySQL**, and **HTML Canvas**.  
Multiple users can draw simultaneously, and drawings persist even after page refresh.

---

## Features

- Real-time drawing using WebSockets (STOMP + SockJS)
- Keyboard-based drawing (Arrow keys to move, Space to draw)
- Drawings persisted in MySQL database
- Automatic reload of saved drawings on page refresh
- Clean layered architecture (Controller, Service, Repository)

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring WebSocket
- Spring Data JPA
- MySQL
- Hibernate

### Frontend
- HTML
- JavaScript
- Canvas API
- SockJS
- STOMP.js

---

## Project Structure

src/main/java/com/example/whiteboard
│
├── controller
│ ├── WhiteboardController.java
│ └── DrawEventRestController.java
│
├── service
│ └── DrawEventService.java
│
├── repository
│ └── DrawEventRepository.java
│
├── model
│ └── DrawEvent.java
│
└── LiveWhiteboardSpringbootApplication.java

src/main/resources
│
├── static
│ └── test.html
│
└── application.properties


---

## Database Design

### Table: `draw_event`

| Column       | Type     | Description            |
|-------------|----------|------------------------|
| id          | BIGINT   | Primary Key            |
| x           | INT      | X coordinate           |
| y           | INT      | Y coordinate           |
| created_at | DATETIME | Time of drawing action |

Each dot drawn on the whiteboard is stored as a separate record.

---

## Application Flow

1. User presses **Space** to draw a dot
2. Dot is immediately drawn on UI (optimistic update)
3. Dot is sent to backend via WebSocket
4. Backend saves dot in MySQL and broadcasts to all users
5. On page refresh, frontend fetches all saved dots via REST API and redraws canvas

---

## How to Run the Project

1. Clone the repository
```bash
git clone <repository-url>


Create MySQL database

CREATE DATABASE whiteboard_db;


Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/whiteboard_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update


Run the application

mvn spring-boot:run


Open in browser

http://localhost:8080/test.html

Key Design Decisions

WebSockets used for real-time collaboration

REST API used for persistence and reload on refresh

Optimistic UI updates for better user experience

Service layer used for clean separation of business logic