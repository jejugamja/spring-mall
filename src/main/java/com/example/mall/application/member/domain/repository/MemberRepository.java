package com.example.mall.application.member.domain.repository;

import com.example.mall.application.member.domain.Member;
import com.example.mall.common.specification.JpaSpecificationRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaSpecificationRepository<Member, Long> {

    Optional<Member> findByMail(String mail);
}
