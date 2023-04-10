package com.example_parseh.service;

import com.example_parseh.entity.JoinAccountEntity;

import java.util.List;

public interface JoinAccountService {
    boolean saveRequest(String usernameReqSender , String usernameReqReceiver);
    boolean acceptRequest(String usernameSen , String usernameRec);
    boolean rejectRequest(String usernameSen , String usernameRec);
    List<JoinAccountEntity> listAll();

}
