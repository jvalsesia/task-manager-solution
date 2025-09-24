package com.github.valsesia.task_manager_be_ms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.valsesia.task_manager_be_ms.dto.CompleteDto;
import com.github.valsesia.task_manager_be_ms.dto.TaskDto;
import com.github.valsesia.task_manager_be_ms.model.Task;
import com.github.valsesia.task_manager_be_ms.repository.TaskRepository;
import com.github.valsesia.task_manager_be_ms.service.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskDto convertToDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted());
    }

    private Task convertToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setCompleted(taskDto.completed());
        return task;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return convertToDto(taskRepository.save(convertToTask(taskDto)));

    }

    @Override
    public List<TaskDto> listTasks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listTasks'");
    }

    @Override
    public CompleteDto completeTask(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completeTask'");
    }

    @Override
    public CompleteDto uncompleteTask(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncompleteTask'");
    }

    @Override
    public Boolean deleteTask(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }

}
