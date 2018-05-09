package com.example.mall.common.entityBuilder;

@FunctionalInterface
public interface ValidateFunction<T> {
    void validate(T t);
}
