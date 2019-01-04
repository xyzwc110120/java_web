package com.cyx.java_web.web_03_CRUD.dao;

import com.cyx.java_web.web_03_CRUD.domain.User;

public interface IUserDAO {

    /**
     * 通过账号获取用户信息
     *
     * @param account 账号
     * @return 用户信息
     */
    User getUserByAccount(String account);

}
