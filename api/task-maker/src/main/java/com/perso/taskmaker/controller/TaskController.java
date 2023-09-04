package com.perso.taskmaker.controller;

import com.perso.taskmaker.model.Task;
import com.perso.taskmaker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return findTaskById(id);
    }




    private Task findTaskById(int id) {
        Task task = new Task();
        task.setId(123);
        task.setDescription("La description de la tâche");
        return task;
    }
}