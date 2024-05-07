package com.example.user_management.model.response;

import com.example.user_management.task_management.dto.TaskPriority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private int id;
    private String name;
    private TaskPriority priority;
    private String description;
    private LocalDateTime deadline;
    private Boolean isCompleted;
}
