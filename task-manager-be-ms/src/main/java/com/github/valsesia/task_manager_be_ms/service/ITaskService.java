package com.github.valsesia.task_manager_be_ms.service;

import java.util.List;

import com.github.valsesia.task_manager_be_ms.dto.CompleteDto;
import com.github.valsesia.task_manager_be_ms.dto.TaskDto;

public interface ITaskService {
    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> listTasks();

    CompleteDto completeTask(String id);

    CompleteDto uncompleteTask(String id);

    Boolean deleteTask(String id);
}
