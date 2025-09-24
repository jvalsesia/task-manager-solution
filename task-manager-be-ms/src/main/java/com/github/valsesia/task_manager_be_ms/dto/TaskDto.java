package com.github.valsesia.task_manager_be_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "TaskDto", description = "Schema to hold Task DTO Information")
public record TaskDto(String id, String title, String description, Boolean completed) {
}
