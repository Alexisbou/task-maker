package com.perso.taskmaker.service;

import com.perso.taskmaker.model.Task;
import com.perso.taskmaker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

    @Override
    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            throw new RuntimeException("Task not found");
        }
        return task.get();
    }

    @Override
    public Task createTask(String description) {
        Task task = new Task();

        task.setDescription(description);

        taskRepository.save(task);

        return task;
    }
}
