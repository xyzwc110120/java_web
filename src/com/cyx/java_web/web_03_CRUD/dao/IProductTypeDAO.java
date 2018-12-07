package com.cyx.java_web.web_03_CRUD.dao;

import com.cyx.java_web.web_03_CRUD.domain.ProductType;

import java.util.List;

public interface IProductTypeDAO {

    /**
     * 获取所有商品类型列表
     */
    List<ProductType> getAll();

}
