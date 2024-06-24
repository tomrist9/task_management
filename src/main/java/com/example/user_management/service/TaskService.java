package com.example.user_management.service;

import com.example.user_management.model.request.TaskCreateRequest;
import com.example.user_management.model.request.TaskUpdateRequest;
import com.example.user_management.model.response.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse create(TaskCreateRequest taskCreateRequest);
    void deleteAllByCategory(String categoryName);
    void deleteById(String id);
    List<TaskResponse> getAllTasks();
    List<TaskResponse> getAllTasksByCategory(String category);
    TaskResponse update(String id, TaskUpdateRequest taskUpdateRequest);

}
