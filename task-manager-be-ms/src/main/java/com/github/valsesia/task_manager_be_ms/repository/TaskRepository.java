package com.github.valsesia.task_manager_be_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.valsesia.task_manager_be_ms.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

}
