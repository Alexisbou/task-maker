package com.perso.taskmaker.service;

import com.perso.taskmaker.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService{
    @Override
    public List<Task> getAllTasks() {
        Task t1 = new Task();
        t1.setId(1);
        t1.setDescription("premier desc");
        Task t2 = new Task();
        t2.setId(2);
        t2.setDescription("deuxieme desc");
        Task t3 = new Task();
        t3.setId(3);
        t3.setDescription("troisieme desc");

        return List.of(t1,t2,t3);
    }
}
