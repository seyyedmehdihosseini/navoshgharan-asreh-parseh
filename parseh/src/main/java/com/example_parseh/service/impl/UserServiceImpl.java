package com.example_parseh.service.impl;

import com.example_parseh.entity.UserEntity;
import com.example_parseh.entity.mapper.AccountMapper;
import com.example_parseh.entity.mapper.UserMapper;
import com.example_parseh.entity.model.AccountModel;
import com.example_parseh.entity.model.UserModel;
import com.example_parseh.repository.UserRepository;
import com.example_parseh.service.UserService;
import com.example_parseh.validation.PhoneValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserMapper userMap;
    @Autowired
    private AccountMapper accountMap;

    @Override
    public UserModel save(UserModel userModel) {
        if (PhoneValidate.validationPhoneNumber(userModel.getPhoneNumber()) &&
                !userRepo.existsByAccount_Username(userModel.getAccount().getUsername())) {
            UserEntity userEntity = userMap.toEntity(userModel);
//            userEntity.setAccount(accountMap.toEntity(account));
            UserEntity newAccountUser = userRepo.save(userEntity);
            return userMap.toModel(newAccountUser);
        } else
            throw new RuntimeException("phoneNumber or username it is unacceptable ");
    }


    @Override
    public List<UserModel> findAll() {
        List<UserEntity> userEntityList = userRepo.findAll();
        if (!userEntityList.isEmpty()){
            List<UserEntity> userList = userEntityList.stream().filter(user -> !user.getDeleteAt()).collect(Collectors.toList());
            return userMap.toListModel(userList);
        }
        throw new NullPointerException("list is a empty ... ");
    }

    @Override
    public boolean login(AccountModel accountEntity) {
        return userRepo.existsByAccount_UsernameAndAccount_Password(accountEntity.getUsername(), accountEntity.getPassword());
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepo.existsByAccount_Username(username);
    }

    @Override
    public UserEntity findByUserName(String username) {
        UserEntity userEntity = userRepo.findByAccount_Username(username);
        if (userEntity.getId()!=null){
            return userEntity;
        }
        return null;
    }


}
