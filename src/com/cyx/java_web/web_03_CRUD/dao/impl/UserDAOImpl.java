package com.cyx.java_web.web_03_CRUD.dao.impl;

import com.cyx.java_web.web_03_CRUD.dao.IUserDAO;
import com.cyx.java_web.web_03_CRUD.domain.User;
import com.cyx.java_web.web_03_CRUD.handler.impl.BeanHandler;
import com.cyx.java_web.web_03_CRUD.template.JDBCTemplate;

public class UserDAOImpl implements IUserDAO {

    @Override
    public User getUserByAccount(String account) {
        String sql = "SELECT u.id, u.account, u.`password` FROM `user` AS u WHERE u.account = ?";
        return JDBCTemplate.query(sql, new BeanHandler<>(User.class), account);
    }
}
