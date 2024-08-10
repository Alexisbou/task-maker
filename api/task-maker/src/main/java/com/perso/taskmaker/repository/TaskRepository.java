package com.perso.taskmaker.repository;

import com.perso.taskmaker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
