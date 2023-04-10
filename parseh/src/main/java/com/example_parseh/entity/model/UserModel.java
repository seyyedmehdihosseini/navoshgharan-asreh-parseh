package com.example_parseh.entity.model;

import lombok.Data;

@Data
public class UserModel {
    private String name;
    private String surname;
    private String phoneNumber;
    private AccountModel account;

}
