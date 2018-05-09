package com.example.mall.application.member.domain;

import com.example.mall.application.member.domain.type.Sex;
import com.example.mall.common.domain.BaseJpaModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseJpaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mail;
    private String password;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String telNo;
    private String address;
    private Boolean receiveSmsYn;
    private Boolean receiveMailYn;

    public Member(String name, String mail, String password, LocalDate birthDay, Sex sex, String telNo, String address, Boolean receiveSmsYn, Boolean receiveMailYn) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.birthDay = birthDay;
        this.sex = sex;
        this.telNo = telNo;
        this.address = address;
        this.receiveSmsYn = receiveSmsYn;
        this.receiveMailYn = receiveMailYn;
    }
}
