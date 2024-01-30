package com.example.user_management.task_management.service;

import com.example.user_management.task_management.dao.entity.TaskEntity;
import com.example.user_management.task_management.dao.repository.TaskRepository;
import com.example.user_management.task_management.dto.TaskDto;
import com.example.user_management.task_management.dto.TaskStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.Arrays;
import java.util.List;

import static com.example.user_management.signin.mapper.TaskMapper.INSTANCE;
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

    public List<TaskStatus> getAllTaskStatus() {
        return Arrays.asList(TaskStatus.values());
    }
    public TaskStatus getTaskStatusByName(String statusName) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.name().equalsIgnoreCase(statusName)) {
                return status;
            }
        }
        return null;
    }
    public boolean isDoneStatus(TaskStatus status) {
        return TaskStatus.DONE.equals(status);
    }
    public TaskStatus getNextTaskStatus(TaskStatus currentStatus) {
        return switch (currentStatus) {
            case TO_DO -> TaskStatus.IN_PROGRESS;
            case IN_PROGRESS -> TaskStatus.IN_REVIEW;
            case IN_REVIEW -> TaskStatus.DONE;
            default -> null;
        };
    }
    public boolean isValidTransition(TaskStatus currentStatus, TaskStatus nextStatus) {
        return getNextTaskStatus(currentStatus) == nextStatus;
    }




}
