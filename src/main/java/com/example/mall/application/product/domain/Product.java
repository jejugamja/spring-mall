package com.example.mall.application.product.domain;

import com.example.mall.common.domain.BaseJpaModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseJpaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String manufacturer;
    private String origin;
    private Integer price;
    private Integer deliveryPrice;
    private Integer freeDeliveryPrice;
    private String thumbnail;
    private String infomationImage;
}
