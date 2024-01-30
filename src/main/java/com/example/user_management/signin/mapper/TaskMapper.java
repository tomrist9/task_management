package com.example.user_management.signin.mapper;

import com.example.user_management.task_management.dao.entity.TaskEntity;
import com.example.user_management.task_management.dto.TaskDto;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;


@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskEntity toEntity(TaskDto dto);

    public default void updateEntityFromDto(TaskEntity existingTask, TaskDto updatedTaskDto){
        existingTask.setName(updatedTaskDto.getName());
        existingTask.setDescription(updatedTaskDto.getDescription());
    }
}
