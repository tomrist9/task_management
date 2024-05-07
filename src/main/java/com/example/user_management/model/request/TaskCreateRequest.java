package com.example.user_management.model.request;

import com.example.user_management.task_management.dto.TaskPriority;
import com.example.user_management.task_management.dto.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCreateRequest {
    @NotEmpty(message = "Task name is required")
    private String taskName;

    @NotNull(message = "Priority can not be empty")
    private TaskPriority priority;
    @NotNull(message = "Task Status can not be null")
    private TaskStatus taskStatus;
    @NotEmpty(message = "Category can not be  empty")
    private String categoryName;

    @JsonIgnore
    private Boolean isDeleted=false;

    private String description;
    private LocalDateTime deadline;
}
