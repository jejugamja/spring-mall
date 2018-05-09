package com.example.mall.application.member.service.specification;

import com.example.mall.common.specification.Specificationable;
import org.springframework.data.jpa.domain.Specification;

public class MemberSpecification implements Specificationable {
    @Override
    public Specification specification() {
        return where(null);
    }
}
