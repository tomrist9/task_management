package com.example.user_management.service.impl;

import com.example.user_management.dao.Category;
import com.example.user_management.dao.Task;
import com.example.user_management.model.UserInfo;
import com.example.user_management.model.request.TaskCreateRequest;
import com.example.user_management.model.request.TaskUpdateRequest;
import com.example.user_management.model.response.TaskResponse;
import com.example.user_management.repository.CategoryRepository;
import com.example.user_management.service.TaskService;
import com.example.user_management.task_management.dao.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Resource(name="requestScopedUser")
    private final UserInfo current;
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public TaskResponse create(TaskCreateRequest taskCreateRequest) {
        Category  category=categoryRepository.findByName(taskCreateRequest.getCategoryName())
                .orElse(Category.builder()
                        .name(taskCreateRequest.getCategoryName())
                        .build());
        Task task=buildTask(taskCreateRequest, category);
        task.setUser(current.getUser());
        taskRepository.save(task);
        return buildTaskResponse(task);

    }

    @Override
    public void deleteAllByCategory(String categoryName) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return null;
    }

    @Override
    public List<TaskResponse> getAllTasksByCategory(String category) {
        return null;
    }

    @Override
    public TaskResponse update(String id, TaskUpdateRequest taskUpdateRequest) {
        return null;
    }
}
