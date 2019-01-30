<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
</head>
<body>
    <%
        pageContext.setAttribute("msg", "pageContextValue");
        request.setAttribute("msg", "requestValue");
        session.setAttribute("msg", "sessionValue");
        application.setAttribute("msg", "applicationValue");

    %>

    <%-- EL 中的四大内置的作用域对象 --%>
    <h1>获取指定作用域中指定属性名的值：</h1>
    <h3>pageContext：${pageScope.get("msg")}</h3>
    <h3>request：${requestScope.get("msg")}</h3>
    <h3>session：${sessionScope.get("msg")}</h3>
    <h3>application：${applicationScope.get("msg")}</h3>
    <br><br>

    <h1>获取 JavaBean 对象的属性值：</h1>
    <%-- 方式一：使用“.”来获取 --%>
    <h3>name：${person.name}</h3>
    <%-- 方式二：使用“["属性名"]”来获取 --%>
    <h3>sex：${person.getSex()}</h3>
    <%-- 方式三：使用方法获取属性值 --%>
    <h3>age：${person["age"]}</h3>
    <h3>array：${person.array[0]}</h3>
    <h3>list：${person.list}</h3>
    <h3>map：${person.map.get("company")}</h3>
    <%-- Map 和 JavaBean 的结构十分相似，所以我们可以像获取 JavaBean 中的属性值一样来获取 Map 的值 --%>
    <%-- <h3>map：${person.map.www.google.com}</h3> --%>
    <%-- 上面因为属性名中带有关键字“.”，所以会让 EL 表达式理解错误，所以我们使用方式二来获取 --%>
    <h3>map：${person.map["www.google.com"]}</h3>
</body>
</html>
