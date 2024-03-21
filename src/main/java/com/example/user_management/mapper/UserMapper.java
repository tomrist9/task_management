package com.example.user_management.mapper;

import com.example.user_management.registration.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class UserMapper {
    UserMapper userMapper= Mappers.getMapper(UserMapper.class);
    User toEntity(UserCreateRequest userCreateRequest);
}
