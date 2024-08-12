package com.perso.taskmaker.service;

import com.perso.taskmaker.dto.CreateTaskRequest;
import com.perso.taskmaker.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<Task> getAllTasks();

    Task findById(Long id);

    Task createTask(CreateTaskRequest description);

    void deleteTaskById(Long id);
}
