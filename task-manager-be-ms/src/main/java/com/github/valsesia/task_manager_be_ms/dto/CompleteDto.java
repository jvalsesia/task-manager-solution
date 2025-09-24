package com.github.valsesia.task_manager_be_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CompleteDto", description = "Schema to hold Complete Task DTO information")
public record CompleteDto(String id, Boolean taskFound, Boolean completed) {
}
