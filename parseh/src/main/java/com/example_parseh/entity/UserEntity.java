package com.example_parseh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_USER", indexes = {@Index(name = "username", columnList = "U_USERNAME"),
        @Index(name = "name", columnList = "U_NAME"),
        @Index(name = "fullName", columnList = "U_NAME , U_SURNAME"),
        @Index(name = "loginAccount",columnList = "U_USERNAME , U_PASSWORD")})
public class UserEntity extends BaseEntity {
    @Column(name = "U_NAME")
    private String name;
    @Column(name = "U_SURNAME")
    private String surname;
    @Column(name = "U_MOBILE" , unique = true)
    private String phoneNumber;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "username", column = @Column(name = "U_USERNAME" , unique = true)),
            @AttributeOverride(name = "password", column = @Column(name = "U_PASSWORD"))})
    private AccountEntity account;

    // self join
    //@OneToMany
    //private List<UserEntity> ListUser;


}
