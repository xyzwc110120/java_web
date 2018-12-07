package com.cyx.java_web.web_03_CRUD.handler.impl;

import com.cyx.java_web.web_03_CRUD.handler.IResultSetHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {

    private Class<T> classType;

    public BeanListHandler(Class<T> tClass) {
        classType = tClass;
    }

    @Override
    public List<T> handle(ResultSet set) throws Exception {
        List<T> ts = new ArrayList<>();

        while (set.next()) {
            T t = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                descriptor.getWriteMethod().invoke(t, set.getObject(descriptor.getName()));
            }
            ts.add(t);
        }
        return ts;
    }
}
