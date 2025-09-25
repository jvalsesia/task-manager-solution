package com.github.valsesia.task_manager_be_ms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.getCompleted());
        return convertToDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> listTasks() {
        return taskRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private TaskDto convertToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.getCompleted());
        return taskDto;
    }

    private CompleteDto setCompleteById(String id, Boolean complete) {
        CompleteDto completeDto = new CompleteDto();
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            completeDto.setTaskfound(true);
            Task presentTask = task.get();
            presentTask.setCompleted(complete);
            taskRepository.save(presentTask);
            completeDto.setId(presentTask.getId());
            completeDto.setTaskfound(true);
            completeDto.setCompleted(presentTask.getCompleted());
        } else {
            completeDto.setTaskfound(false);
        }
        return completeDto;
    }

    @Override
    public CompleteDto completeTask(String id) {
        return setCompleteById(id, true);

    }

    @Override
    public CompleteDto uncompleteTask(String id) {
        return setCompleteById(id, false);
    }

    @Override
    public Boolean deleteTask(String id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
