package com.cyx.java_web.web_03_CRUD.test;

import com.cyx.java_web.web_03_CRUD.dao.IUserDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.UserDAOImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserDAOTest {

    private IUserDAO dao = new UserDAOImpl();

    @Test
    @DisplayName("测试通过账号获取用户信息")
    void testGetUserByAccount() {
        System.out.println(dao.getUserByAccount("admin"));
    }

}
