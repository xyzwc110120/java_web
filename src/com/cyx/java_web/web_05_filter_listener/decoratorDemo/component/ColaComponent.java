package com.cyx.java_web.web_05_filter_listener.decoratorDemo.component;

/**
 * 被装饰的可乐类
 */
public class ColaComponent extends Drink {

    public ColaComponent() {
        super.name = "可乐";
    }

    @Override
    public int price() {
        return 4;
    }
}
