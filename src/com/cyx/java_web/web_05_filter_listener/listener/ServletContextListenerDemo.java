package com.cyx.java_web.web_05_filter_listener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建应用对象");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁应用对象");
    }
}
