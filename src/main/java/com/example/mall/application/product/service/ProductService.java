package com.example.mall.application.product.service;

import com.example.mall.application.product.domain.Product;
import com.example.mall.application.product.domain.repository.ProductRepository;
import com.example.mall.common.specification.JpaSpecificationRepository;
import com.example.mall.common.specification.SpecificationService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements SpecificationService<Product, Long> {

    private ProductRepository productRepository;

    @Override
    public JpaSpecificationRepository<Product, Long> getRepository() {
        return null;
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
