// src/services/apiService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const fetchTasks = async () => {
    const response = await axios.get(`${API_URL}/tasks`);
    return response.data;
};

export const createTask = async (task) => {
    const response = await axios.post(`${API_URL}/tasks`, task);
    return response.data;
};

export const deleteTask = async (taskId) => {
    await axios.delete(`${API_URL}/tasks/${taskId}`);
};
