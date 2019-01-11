package com.cyx.java_web.web_05_filter_listener.decoratorDemo.component;


/**
 * 饮品抽象类，装饰者模式中最顶级的父类
 */
public abstract class Drink {

    /**
     * 饮品名称
     */
    String name;

    /**
     * 让每个实现“饮品”类的子类自己决定是多少钱
     */
    public abstract int price();

    public String getName() {
        return name;
    }
}
