package com.example.user_management.mapper;

import com.example.user_management.dao.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class TaskMapper {
    TaskMapper mapper= Mappers.getMapper(TaskMapper.class);
    Task taskCreateRequestToTask(TaskCreateRequest taskCreateRequest);
    TaskResponse taskEntityToTaskResponse(Task task);
}
