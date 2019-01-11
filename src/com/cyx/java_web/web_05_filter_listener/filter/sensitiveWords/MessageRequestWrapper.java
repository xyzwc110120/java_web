package com.cyx.java_web.web_05_filter_listener.filter.sensitiveWords;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
    装饰（Decorator）模式，又名包装(Wrapper)模式。

    装饰器模式是一种结构型的设计模式。使用该模式的目的是为了较为灵活的对类进行扩展，而且不影响原来类的结构。
    有同学说可以通过继承的方式进行实现啊，没错，继承的确可以实现，但是继承的成本相对比较高，而且如果涉及到扩展多个功能的话，
    继承实现起来的成本较大。

    装饰器模式的思想是，对原来的类进行一层封装，通过依赖实现扩展。但是装饰器的依赖有两个比较重要的特点：

        第一，装饰器的抽象类，依赖的是原来类的接口。装饰器的实现类与原本的类之间，不会存在耦合的现象，两个类可以各自进行对应的变化。
        这一点与桥接模式是相同的。

        第二，装饰器的抽象类会同时继承原来类的接口，从而保证装饰器的实现类具有与原来的类一样的方法，只是装饰器实现类的方法有新的扩展。
        可以理解为对原有类的某种功能或者特性的加强。这样产生的效果就是，从使用者的角度来看，会更加的便捷，因为原来的类与装饰器类具有一样的方法，
        但是其中实际的功能和作用进行了加强。

    装饰器模式的使用场景，抽象来说就是需要扩展类但是又不想引入子类，或者也可以根据字面的含义，能与装饰或者功能加强有关的场景。
    比如说，一张画，是可以欣赏的，但是没有办法挂到墙上。那么我们可以找一个相框（装饰器实现类），将画放到相框中，
    之后就可以把这个带相框的画挂到墙上了。再比如说，我们买了一张床，就可以在上边睡觉了。但是我们希望睡的更加舒服，
    所以需要在床上增加一个装饰，比如垫上床垫，加上枕头，盖上床单。装饰之后，它依然有承载睡觉的属性。
*/
public class MessageRequestWrapper extends HttpServletRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public MessageRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 覆盖 getParameter 方法，在方法中做敏感字过滤处理
     *
     * @param name 请求参数名
     * @return 请求内容
     */
    @Override
    public String getParameter(String name) {
        return SensitiveWordsUtil.filter(super.getParameter(name));
    }
}
