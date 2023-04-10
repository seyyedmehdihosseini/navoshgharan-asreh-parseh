package com.example_parseh.repository;

import com.example_parseh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>,
        CrudRepository<UserEntity, Integer> {
        boolean existsByAccount_Username(String username);
        boolean existsByAccount_UsernameAndAccount_Password(String username , String password);
        UserEntity findByAccount_Username(String username);

}
