package com.example.mall.application.member.domain.builder;

import com.example.mall.application.member.domain.Member;
import com.example.mall.application.member.domain.type.Sex;
import com.example.mall.common.entityBuilder.EntityBuilder;
import com.example.mall.common.exception.BindingException;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class MemberBuilder implements EntityBuilder<Member> {
    @Size(max = 50, min = 1)
    private String name;
    @Max(150)
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")
    private String mail;
    @Size(max = 100, min = 8)
    private String password;
    @NotEmpty
    private LocalDate birthDay;
    @NotEmpty
    private String sex;
    @NotEmpty
    private String telNo;
    @NotEmpty
    private String address;
    @NotEmpty
    private Boolean receiveSmsYn;
    @NotEmpty
    private Boolean receiveMailYn;

    @Override
    public Member build() {
        return new Member(name, mail, password, birthDay, getSex(), telNo, address, receiveSmsYn, receiveMailYn);
    }

    private Sex getSex() {
        try {
            return Sex.valueOf(this.sex);
        } catch (Exception e) {
            throw new BindingException();
        }

    }
}

