<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EL 的其他细节</title>
</head>
<body>
    <%-- 获取上下文路径 --%>
    <h3>获取上下文路径：<%= request.getContextPath() %></h3>
    <%-- 从 Tomcat7 开始，支持在 EL 中调用方法 --%>
    <h3>获取上下文路径：${pageContext.getRequest().getContextPath()}</h3>
    <%-- 可以看到，上面 getRequest() 和 getContextPath() 都是获取属性的方法，所以可以直接在 EL 表达式中使用属性名来获取属性值 --%>
    <h3>获取上下文路径：${pageContext.request.contextPath}</h3>
    <br><br>

    <%-- 可以在 EL 中编写运算式 --%>
    <h3>1 + 1 = ${1 + 1}</h3>
    <br><br>

    <%-- 可以判断集合是否为空（注意，这里判断的是集合中是否有元素，而不是判断是否创建了集合对象） --%>
    <% pageContext.setAttribute("list", new ArrayList<String>()); %>
    <h3>list 集合是否为空：${empty list}</h3>
    <%-- 下面是两种取反的方式 --%>
    <h3>list 集合是否不为空：${not empty list}</h3>
    <h3>list 集合是否不为空：${!empty list}</h3>
    <br><br>

    <%-- 可以作比较 --%>
    <h3>1 == 1：${1 == 1}</h3>
    <h3>1 == 1：${1 eq 1}</h3>
</body>
</html>