package com.example_parseh.service.impl;

import com.example_parseh.entity.JoinAccountEntity;
import com.example_parseh.entity.UserEntity;
import com.example_parseh.entity.mapper.UserMapper;
import com.example_parseh.repository.JoinAccountRepository;
import com.example_parseh.service.JoinAccountService;
import com.example_parseh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinAccountServiceImpl implements JoinAccountService {
    @Autowired
    private JoinAccountRepository accountRepo;
    @Autowired
    private UserService userServ;
    @Autowired
    private UserMapper userMap;

    @Override
    public boolean saveRequest(String usernameReqSender, String usernameReqReceiver) {
        List<UserEntity> allUsers = userMap.toListEntity(userServ.findAll());
        UserEntity userSender = (UserEntity) allUsers.stream().filter(user -> user.getAccount().getUsername().equalsIgnoreCase(usernameReqSender));
        UserEntity userReceiver = (UserEntity) allUsers.stream().filter(user -> user.getAccount().getUsername().equalsIgnoreCase(usernameReqReceiver));
        if (userSender.getId() != null && userReceiver.getId() != null) {
            JoinAccountEntity joinAccountEntity = new JoinAccountEntity();
            joinAccountEntity.setUserReqSender(userSender);
            joinAccountEntity.setUserReqReceiver(userReceiver);
            JoinAccountEntity newApplyForJoin = accountRepo.save(joinAccountEntity);
            if (newApplyForJoin.getId() != null) {
                return true;
            }
            throw new RuntimeException("Operation save failed ... ");
        }
        throw new RuntimeException("user by this username is not found ... ");
    }

    @Override
    public boolean acceptRequest(String usernameSen, String usernameRec) {
        JoinAccountEntity accountAcc = accountRepo.findByUserReqSender_Account_UsernameAndUserReqReceiver_Account_Username(usernameSen, usernameRec);
        if (accountAcc.getId() != null) {
            accountAcc.setAcceptReq(true);
            JoinAccountEntity updateJoin = accountRepo.save(accountAcc);
            if (updateJoin.getId() != null) {
                return true;
            }
        }
        throw new RuntimeException("username is not found");
    }

    @Override
    public boolean rejectRequest(String usernameSen, String usernameRec) {
        JoinAccountEntity accountRej = accountRepo.findByUserReqSender_Account_UsernameAndUserReqReceiver_Account_Username(usernameSen, usernameRec);
        if (accountRej.getId()!=null){
            accountRepo.deleteById(accountRej.getId());
            return true;
        }
        throw new RuntimeException("username is not found");
    }

    @Override
    public List<JoinAccountEntity> listAll() {
        return null;
    }


}
