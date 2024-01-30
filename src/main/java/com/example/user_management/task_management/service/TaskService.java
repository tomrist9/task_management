package com.example.user_management.service;

import com.example.user_management.dao.entity.TaskEntity;
import com.example.user_management.dao.repository.TaskRepository;
import com.example.user_management.dto.TaskDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static com.example.user_management.mapper.TaskMapper.INSTANCE;
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(TaskDto task) {
        var entity = INSTANCE.toEntity(task);
        entity = taskRepository.save(entity);
    }


     public void editTask(Long taskId, TaskDto updatedTaskDto){
         TaskEntity existingTask=taskRepository.findById(taskId)
                 .orElseThrow(()->new EntityNotFoundException("Entity not found with"+ taskId));

         INSTANCE.updateEntityFromDto(existingTask, updatedTaskDto);

         taskRepository.save(existingTask);
     }
     public void deleteTask(Long taskId){
         taskRepository.deleteById(taskId);
     }

     public List<TaskEntity> getAllTasks() {
         return taskRepository.findAll();
     }

     public TaskEntity getTaskById(Long taskId) {
         return taskRepository.getById(taskId);
     }
 }
