package com.cyx.java_web.web_03_CRUD.test;

import com.cyx.java_web.web_03_CRUD.dao.IProductDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.ProductDAOImpl;
import com.cyx.java_web.web_03_CRUD.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductDAOTest {

    private IProductDAO dao = new ProductDAOImpl();

    @Test
    @DisplayName("新增商品")
    void testAdd() {
        dao.add(new Product(
                2, "碰碰车", "可以撞的碰碰车", new BigDecimal(7000),
                new BigDecimal(15000), new BigDecimal(10000)));
    }

    @Test
    @DisplayName("获取所有商品信息")
    void testGetAll() {
        System.out.println(dao.getAll());
    }

    @Test
    @DisplayName("获取指定商品信息")
    void testGet() {
        System.out.println(dao.get(1L));
    }

    @Test
    @DisplayName("修改制定商品")
    void testUpdate() {
        dao.update(new Product(2L, 1, "轮船", "可以游的轮船",
                new BigDecimal(1000000), new BigDecimal(10000000), new BigDecimal(7000000)));
    }

    @Test
    @DisplayName("删除指定商品")
    void testDelete() {
        dao.delete(5L);
    }

}
