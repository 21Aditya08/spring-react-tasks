package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContainingIgnoreCase(String title);
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdNot(String title, Long id);
    Optional<Task> findByTitle(String title);
}
