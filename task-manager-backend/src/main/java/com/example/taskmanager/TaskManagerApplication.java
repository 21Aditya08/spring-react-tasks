package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
    
    @GetMapping("/health")
    public String health() {
        return "Backend is running! Database URL configured: " + (System.getenv("DATABASE_URL") != null ? "✅" : "❌");
    }
}
