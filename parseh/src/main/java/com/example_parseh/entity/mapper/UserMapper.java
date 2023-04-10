package com.example_parseh.entity.mapper;

import com.example_parseh.entity.UserEntity;
import com.example_parseh.entity.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, UserModel> {

}
