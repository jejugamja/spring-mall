package com.example.mall.application.member.service;

import com.example.mall.application.member.domain.Member;
import com.example.mall.application.member.domain.builder.MemberBuilder;
import com.example.mall.application.member.domain.repository.MemberRepository;
import com.example.mall.application.member.service.validate.MemberValidator;
import com.example.mall.common.specification.JpaSpecificationRepository;
import com.example.mall.common.specification.SpecificationService;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements SpecificationService<Member, Long> {

    private MemberRepository memberRepository;
    private MemberValidator.MailExistsValidator mailExistsValidator;

    public MemberService(MemberRepository memberRepository, MemberValidator.MailExistsValidator mailExistsValidator) {
        this.memberRepository = memberRepository;
        this.mailExistsValidator = mailExistsValidator;
    }

    @Override
    public JpaSpecificationRepository<Member, Long> getRepository() {
        return memberRepository;
    }

    public Member signUp(MemberBuilder memberBuilder) {
        return memberBuilder
                .validate(mailExistsValidator)
                .build(memberRepository::save);
    }
}
