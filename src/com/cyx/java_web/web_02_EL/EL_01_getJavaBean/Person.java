package com.cyx.java_web.web_02_EL.EL_01_getJavaBean;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 注意，一定要设置属性，不然会报找不到该属性的错误，并且一定要有 getter 方法，不然无法获取属性 */
@Getter
public class Person {

    private String name = "哦哈哈哈";
    private String sex = "男";
    private Integer age = 18;
    private String[] array = {"Java", "Android", "iOS"};
    private List<String> list = Arrays.asList("list1", "list2", "list3");
    // 可以通过下面方式在创建 Map 集合时往 Map 对象中设置值
    private Map<String, String> map = new HashMap<String, String>() {
        private static final long serialVersionUID = 4449567824498535054L;
        {
            this.put("company", "斑马");
            this.put("www.google.com", "谷歌");
        }
    };
}
