package com.github.valsesia.task_manager_be_ms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.valsesia.task_manager_be_ms.dto.CompleteDto;
import com.github.valsesia.task_manager_be_ms.dto.TaskDto;
import com.github.valsesia.task_manager_be_ms.service.ITaskService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
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

    @GetMapping("/list")
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<TaskDto> tasks = iTaskService.listTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PatchMapping("/complete")
    public ResponseEntity<CompleteDto> completeTask(@RequestParam String id) {
        CompleteDto completeDto = iTaskService.completeTask(id);
        log.info("Complete: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(completeDto);
    }

    @PatchMapping("/uncomplete")
    public ResponseEntity<CompleteDto> uncompleteTask(@RequestParam String id) {
        CompleteDto completeDto = iTaskService.uncompleteTask(id);
        log.info("Uncomplete: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(completeDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteTask(@RequestParam String id) {
        Boolean deleted = iTaskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

}
