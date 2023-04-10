package com.example_parseh.repository;

import com.example_parseh.entity.JoinAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinAccountRepository extends CrudRepository<JoinAccountEntity,Integer>
        , JpaRepository<JoinAccountEntity,Integer> {
    JoinAccountEntity findByUserReqSender_Account_UsernameAndUserReqReceiver_Account_Username(String usernameSen, String usernameRec);

}
