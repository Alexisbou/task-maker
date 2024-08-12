// src/components/TaskForm.js
import React, { useState } from 'react';
import { TextField, Button, Box } from '@mui/material';

const TaskForm = ({ addTask }) => {
    const [taskName, setTaskName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (taskName.trim()) {
            addTask(taskName);
            setTaskName('');
        }
    };

    return (
        <Box component="form" onSubmit={handleSubmit} sx={{ display: 'flex', gap: 2, marginBottom: 2 }}>
            <TextField
                variant="outlined"
                label="New Task"
                value={taskName}
                onChange={(e) => setTaskName(e.target.value)}
                fullWidth
            />
            <Button variant="contained" color="primary" type="submit">
                Add
            </Button>
        </Box>
    );
};

export default TaskForm;
