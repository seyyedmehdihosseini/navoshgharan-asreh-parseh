package com.example_parseh.service;

import com.example_parseh.entity.UserEntity;
import com.example_parseh.entity.model.AccountModel;
import com.example_parseh.entity.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel save(UserModel user ); //UserModel user , AccountModel account
    List<UserModel> findAll();
    boolean login(AccountModel accountEntity);
    boolean existByUsername(String username);
    UserEntity findByUserName(String username);
}
