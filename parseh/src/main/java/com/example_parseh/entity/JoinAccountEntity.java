package com.example_parseh.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_JOIN_ACCOUNT")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JoinAccountEntity extends BaseEntity{
    @JoinColumn(name = "JA_USER_REQ_SENDER")
    @ManyToOne
    private UserEntity userReqSender;
    @JoinColumn(name = "JA_USER_REQ_RECEIVER")
    @ManyToOne
    private UserEntity userReqReceiver;
    @Column(name = "JA_ACCEPT_REQUEST")
    private Boolean acceptReq = false;
    @Column(name = "JA_REJECT_REQUEST")
    private Boolean rejectReq = false;
}
