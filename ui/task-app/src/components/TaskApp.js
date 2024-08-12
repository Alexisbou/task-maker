// src/components/TaskApp.js
import React, { useEffect, useState } from 'react';
import { Container, Typography, CircularProgress } from '@mui/material';
import TaskList from './TaskList';
import TaskForm from './TaskForm';
import { fetchTasks, createTask, deleteTask } from '../services/apiService';

const TaskApp = () => {
    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        loadTasks();
    }, []);

    const loadTasks = async () => {
        try {
            const data = await fetchTasks();
            setTasks(data);
        } catch (error) {
            console.error('Error loading tasks:', error);
        } finally {
            setLoading(false);
        }
    };

    const addTask = async (taskName) => {
        try {
            const newTask = await createTask({description: taskName})
            setTasks([...tasks, newTask]);
        } catch (error) {
            console.error('Error adding task:', error);
        }
    };

    const handleDeleteTask = async (taskId) => {
        try {
            await deleteTask(taskId);
            setTasks(tasks.filter((task) => task.id !== taskId));
        } catch (error) {
            console.error('Error deleting task:', error);
        }
    };

    return (
        <Container maxWidth="sm">
            <Typography variant="h4" align="center" gutterBottom>
                Task Manager
            </Typography>
            <TaskForm addTask={addTask} />
            {loading ? (
                <CircularProgress />
            ) : (
                <TaskList tasks={tasks} deleteTask={handleDeleteTask} />
            )}
        </Container>
    );
};

export default TaskApp;
