package com.cyx.java_web.web_05_filter_listener.decoratorDemo.decorator;

import com.cyx.java_web.web_05_filter_listener.decoratorDemo.component.Drink;

/**
 * 饮品装饰类，所有装饰类的父类
 */
public abstract class DrinkDecorator extends Drink {

    protected Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }
}
