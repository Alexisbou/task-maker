package com.perso.taskmaker.unit;

import com.perso.taskmaker.model.Task;
import com.perso.taskmaker.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testFindById() {
        // Insert data using TestEntityManager
        Task task = new Task();
        task.setDescription("Test Task 1");

        entityManager.persist(task);
        entityManager.flush();

        // Test the repository
        Optional<Task> foundTask = taskRepository.findById(task.getId());
        assertTrue(foundTask.isPresent());
        assertEquals("Test Task 1", foundTask.get().getDescription());
    }
}