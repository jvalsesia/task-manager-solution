package com.github.valsesia.task_manager_be_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CompleteDto", description = "Schema to hold Complete Task information")
public class CompleteDto {
    private String id;
    private Boolean taskfound;
    private Boolean completed;
}
