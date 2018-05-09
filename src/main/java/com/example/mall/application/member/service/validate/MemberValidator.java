package com.example.mall.application.member.service.validate;

import com.example.mall.application.member.domain.builder.MemberBuilder;
import com.example.mall.application.member.domain.repository.MemberRepository;
import com.example.mall.application.member.service.exception.MailExistsException;
import com.example.mall.common.entityBuilder.ValidateFunction;
import org.springframework.stereotype.Service;

public class MemberValidator {

    @Service
    public static class MailExistsValidator implements ValidateFunction<MemberBuilder> {
        private MemberRepository memberRepository;

        public MailExistsValidator(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }

        @Override
        public void validate(MemberBuilder memberBuilder) {
            memberRepository.findByMail(memberBuilder.getMail())
                    .ifPresent(m -> {
                        throw new MailExistsException();
                    });

        }

    }
}
