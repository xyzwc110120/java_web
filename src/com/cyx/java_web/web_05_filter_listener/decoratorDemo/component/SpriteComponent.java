package com.cyx.java_web.web_05_filter_listener.decoratorDemo.component;

/**
 * 被装饰的雪碧类
 */
public class SpriteComponent extends Drink {

    public SpriteComponent() {
        super.name = "雪碧";
    }

    @Override
    public int price() {
        return 3;
    }
}
