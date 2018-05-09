package com.example.mall.application.member.ui;

import com.example.mall.application.member.domain.Member;
import com.example.mall.application.member.domain.builder.MemberBuilder;
import com.example.mall.application.member.service.MemberService;
import com.example.mall.application.member.service.exception.MailExistsException;
import com.example.mall.application.member.service.specification.MemberSpecification;
import com.example.mall.common.exception.BindingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signUp")
    public Member signUp(MemberBuilder memberBuilder, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new BindingException(bindingResult);
        return memberService.signUp(memberBuilder);
    }

    @GetMapping("/members")
    public List list(MemberSpecification specification) {
        return  memberService.findAll(specification);
    }

    @ExceptionHandler
    public ResponseEntity handle(BindingException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("올바르지 않은 정보입니다.");
    }

    @ExceptionHandler
    public ResponseEntity handleM(MailExistsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("이미 존재하는 매일입니다. 다른 메일을 입력해 주세요.");
    }
}
