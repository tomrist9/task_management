package com.example.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;

    private String name;
    private TaskPriority taskPriority;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus taskStatus;
}
