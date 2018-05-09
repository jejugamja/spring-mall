package com.example.mall.common.exception;

import org.springframework.validation.BindingResult;

public class BindingException extends RuntimeException {

    private BindingResult bindingResult;

    public BindingException() {
    }

    public BindingException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
