package com.cyx.java_web.web_03_CRUD.dao.impl;

import com.cyx.java_web.web_03_CRUD.dao.IProductDAO;
import com.cyx.java_web.web_03_CRUD.domain.Product;
import com.cyx.java_web.web_03_CRUD.handler.impl.BeanHandler;
import com.cyx.java_web.web_03_CRUD.handler.impl.BeanListHandler;
import com.cyx.java_web.web_03_CRUD.template.JDBCTemplate;

import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        JDBCTemplate.update(sql, id);
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO product (product_type_id, `name`, brand, purchasing_price, original_price, " +
                "current_price) VALUES (?, ?, ?, ?, ? ,?)";
        JDBCTemplate.update(sql, product.getProductTypeId(), product.getName(), product.getBrand(),
                product.getPurchasingPrice(), product.getOriginalPrice(), product.getCurrentPrice());
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product p SET p.product_type_id = ?, p.`name` = ?, p.brand = ?, " +
                "p.purchasing_price = ?, p.original_price = ?, p.current_price = ? WHERE p.id = ?";
        JDBCTemplate.update(sql, product.getProductTypeId(), product.getName(), product.getBrand(),
                product.getPurchasingPrice(), product.getOriginalPrice(), product.getCurrentPrice(), product.getId());
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT p.id, p.product_type_id productTypeId, p.`name`, p.brand, " +
                "p.purchasing_price purchasingPrice, p.original_price originalPrice, p.current_price currentPrice FROM product p";
        return JDBCTemplate.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public Product get(Long id) {
        String sql = "SELECT p.id, p.product_type_id productTypeId, p.`name`, p.brand, " +
                "p.purchasing_price purchasingPrice, p.original_price originalPrice, p.current_price currentPrice " +
                "FROM product p WHERE p.id = ?";
        return JDBCTemplate.query(sql, new BeanHandler<>(Product.class), id);
    }
}
