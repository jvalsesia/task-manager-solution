package com.github.valsesia.task_manager_be_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Task", description = "Schema to hold Task information")
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private Boolean completed;
}
