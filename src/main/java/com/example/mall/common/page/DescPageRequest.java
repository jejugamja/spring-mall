package com.example.mall.common.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DescPageRequest {

    private int page;

    private int getPage() {
        if (page < 0)
            return 0;
        return page;
    }

    public Pageable pageable() {
        return PageRequest.of(getPage(), 20, Sort.by(Sort.Order.desc("createdAt")));
    }
}
