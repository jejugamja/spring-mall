package com.example.mall.application.product.domain.repository;

import com.example.mall.application.product.domain.Product;
import com.example.mall.common.specification.JpaSpecificationRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaSpecificationRepository<Product, Long> {
}
