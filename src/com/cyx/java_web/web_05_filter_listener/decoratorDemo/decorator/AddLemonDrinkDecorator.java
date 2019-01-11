package com.cyx.java_web.web_05_filter_listener.decoratorDemo.decorator;

import com.cyx.java_web.web_05_filter_listener.decoratorDemo.component.Drink;

public class AddLemonDrinkDecorator extends DrinkDecorator {

    public AddLemonDrinkDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public int price() {
        return super.drink.price() + 3;
    }

    @Override
    public String getName() {
        return "加柠檬的" + super.drink.getName();
    }
}
