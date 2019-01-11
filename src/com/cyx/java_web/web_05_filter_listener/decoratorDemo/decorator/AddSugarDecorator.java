package com.cyx.java_web.web_05_filter_listener.decoratorDemo.decorator;

import com.cyx.java_web.web_05_filter_listener.decoratorDemo.component.Drink;

public class AddSugarDecorator extends DrinkDecorator {

    public AddSugarDecorator(Drink drink) {
        super(drink);
    }

    /**
     * 覆盖原先的价格方法
     * @return 加糖后的价格
     */
    @Override
    public int price() {
        return super.drink.price() + 1;
    }


    /**
     * 覆盖原先的获取名称方法
     * @return 添加后的名称
     */
    @Override
    public String getName() {
        return "加糖的" + super.drink.getName();
    }
}
