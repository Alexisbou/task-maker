package com.perso.taskmaker.service;

import com.perso.taskmaker.dto.CreateTaskRequest;
import com.perso.taskmaker.model.Task;
import com.perso.taskmaker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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
    public Task createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();

        task.setDescription(createTaskRequest.getDescription());

        taskRepository.save(task);

        return task;
    }

    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        taskRepository.deleteById(id);
    }
}
