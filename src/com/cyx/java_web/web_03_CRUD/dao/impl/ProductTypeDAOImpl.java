package com.cyx.java_web.web_03_CRUD.dao.impl;

import com.cyx.java_web.web_03_CRUD.dao.IProductTypeDAO;
import com.cyx.java_web.web_03_CRUD.domain.ProductType;
import com.cyx.java_web.web_03_CRUD.handler.impl.BeanListHandler;
import com.cyx.java_web.web_03_CRUD.template.JDBCTemplate;

import java.util.List;

public class ProductTypeDAOImpl implements IProductTypeDAO {

    @Override
    public List<ProductType> getAll() {
        String sql = "SELECT pt.id, pt.`name` FROM product_type pt";
        return JDBCTemplate.query(sql, new BeanListHandler<>(ProductType.class));
    }
}
