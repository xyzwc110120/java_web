package com.cyx.java_web.web_03_CRUD.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductType {

    private Integer id;            // 商品类型id
    private String name;        // 商品类型名称

    public ProductType() {
    }
}
