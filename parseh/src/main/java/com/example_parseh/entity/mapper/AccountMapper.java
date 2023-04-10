package com.example_parseh.entity.mapper;

import com.example_parseh.entity.AccountEntity;
import com.example_parseh.entity.model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<AccountEntity, AccountModel>{
}
