package com.cyx.java_web.web_03_CRUD.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {

    T handle(ResultSet set) throws Exception;
}
