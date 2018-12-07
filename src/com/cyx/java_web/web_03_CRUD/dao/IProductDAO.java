package com.cyx.java_web.web_03_CRUD.dao;

import com.cyx.java_web.web_03_CRUD.domain.Product;

import java.util.List;

public interface IProductDAO {

    /**
     * 删除指定商品
     *
     * @param id 商品id
     */
    void delete(Long id);

    /**
     * 新增商品
     *
     * @param product 商品信息
     */
    void add(Product product);

    /**
     * 修改商品
     *
     * @param product 商品信息
     */
    void update(Product product);

    /**
     * 获取所有商品信息
     *
     * @return 所有商品集合
     */
    List<Product> getAll();

    /**
     * 获取指定商品信息
     *
     * @param id 商品id
     * @return 商品信息
     */
    Product get(Long id);

}
