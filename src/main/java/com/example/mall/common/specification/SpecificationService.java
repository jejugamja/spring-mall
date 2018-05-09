package com.example.mall.common.specification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SpecificationService<T, ID> {

    JpaSpecificationRepository<T, ID> getRepository();

    default Optional<T> findOne(ID id) {
        return getRepository().findById(id);
    }

    default Optional<T> findOne(Specificationable<T> s) {
        return getRepository().findOne(s.specification());
    }

    default List<T> findAll(Specificationable<T> s) {
        return getRepository().findAll(s.specification());
    }

    default Page<T> findAll(Specificationable<T> s, Pageable pageable) {
        return getRepository().findAll(s.specification(), pageable);
    }

    default long count(Specificationable<T> s) {
        return getRepository().count(s.specification());
    }
}
