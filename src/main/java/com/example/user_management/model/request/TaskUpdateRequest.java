package com.example.user_management.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUpdateRequest {
    private String name;
    private String priority;
    private String status;
    private String description;
    private String categoryName;
}
