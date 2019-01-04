package com.cyx.java_web.web_03_CRUD.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 5408919709067013875L;

    private Long id;
    private String account;         // 账号
    private String password;        // 密码
}
