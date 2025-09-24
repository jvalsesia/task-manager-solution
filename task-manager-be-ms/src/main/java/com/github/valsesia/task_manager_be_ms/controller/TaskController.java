package com.github.valsesia.task_manager_be_ms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.valsesia.task_manager_be_ms.dto.TaskDto;
import com.github.valsesia.task_manager_be_ms.service.ITaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TaskController {
    private final ITaskService iTaskService;

    public TaskController(ITaskService iTaskService) {
        this.iTaskService = iTaskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = iTaskService.createTask(taskDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

}
