package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.exception.DuplicateTaskTitleException;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskResponse> getAll(String title) {
        var tasks = (title == null || title.isBlank())
                ? taskRepository.findAll()
                : taskRepository.findByTitleContainingIgnoreCase(title);
        return tasks.stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TaskResponse getById(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));
        return toResponse(task);
    }

    @Override
    public TaskResponse create(TaskRequest request) {
        // Check if title already exists
        if (taskRepository.existsByTitle(request.getTitle())) {
            throw new DuplicateTaskTitleException("A task with title '" + request.getTitle() + "' already exists");
        }
        
        var task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setDeadline(parseDeadline(request.getDeadline()));
        var saved = taskRepository.save(task);
        return toResponse(saved);
    }

    @Override
    public TaskResponse update(Long id, TaskRequest request) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));
        
        // Check if title already exists (excluding current task)
        if (taskRepository.existsByTitleAndIdNot(request.getTitle(), id)) {
            throw new DuplicateTaskTitleException("A task with title '" + request.getTitle() + "' already exists");
        }
        
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setDeadline(parseDeadline(request.getDeadline()));
        var saved = taskRepository.save(task);
        return toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));
        taskRepository.delete(task);
    }

    private Instant parseDeadline(String deadlineStr) {
        if (deadlineStr == null || deadlineStr.trim().isEmpty()) {
            return null;
        }
        
        try {
            // Try to parse as ISO instant first (e.g., "2025-09-06T15:30:00.000Z")
            return Instant.parse(deadlineStr);
        } catch (Exception e1) {
            try {
                // If that fails, try to parse as LocalDateTime and convert to Instant
                LocalDateTime localDateTime = LocalDateTime.parse(deadlineStr);
                return localDateTime.toInstant(ZoneOffset.UTC);
            } catch (Exception e2) {
                // If both fail, log the error and return null
                System.err.println("Failed to parse deadline: " + deadlineStr + ". Error: " + e2.getMessage());
                return null;
            }
        }
    }

    private TaskResponse toResponse(Task task) {
        var dto = new TaskResponse();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setDeadline(task.getDeadline());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        return dto;
    }
}
