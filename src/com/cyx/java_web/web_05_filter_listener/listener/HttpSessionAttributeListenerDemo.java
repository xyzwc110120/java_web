package com.cyx.java_web.web_05_filter_listener.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("添加属性：" + se.getName() + "-" + se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("删除属性：" + se.getName() + "-" + se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("替换属性：" + se.getName() + "-" + se.getValue());
        /* 上面打印的是替换前的属性值，如果要打印已经替换的属性值，用下面的方式 */
        System.out.println("替换后属性：" + se.getName() + "-" + se.getSession().getAttribute(se.getName()));
    }
}
