package com.cyx.java_web.web_05_filter_listener.decoratorDemo.test;

import com.cyx.java_web.web_05_filter_listener.decoratorDemo.component.ColaComponent;
import com.cyx.java_web.web_05_filter_listener.decoratorDemo.component.SpriteComponent;
import com.cyx.java_web.web_05_filter_listener.decoratorDemo.decorator.AddLemonDrinkDecorator;
import com.cyx.java_web.web_05_filter_listener.decoratorDemo.decorator.AddSugarDecorator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrinkTest {

    @Test
    @DisplayName("包装模式：可乐加柠檬测试")
    void colaAddLemonTest(){
        AddLemonDrinkDecorator addLemon = new AddLemonDrinkDecorator(new ColaComponent());
        System.out.println(addLemon.getName() + "：" + addLemon.price());
    }

    @Test
    @DisplayName("雪碧加糖加柠檬测试")
    void addSugarTest() {
        AddSugarDecorator addSugar = new AddSugarDecorator(new AddLemonDrinkDecorator(new SpriteComponent()));
        System.out.println(addSugar.getName() + "：" + addSugar.price());
    }
}
