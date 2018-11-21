<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>judgment</title>
</head>
<body>
    <% pageContext.setAttribute("num", 20); %>

    <!-- 单条件判断 -->
    <!-- 语法 1：若条件满足，则输出 if 标签中的内容 --%>
    <c:if test="${num > 10}">
        <h3>num 大于 10</h3>
    </c:if>
    <!-- 语法 2：把判断的结果（true / false），存储在一个变量中 --%>
    <c:if test="${num < 10}" var="result" scope="page" />
    <%--
        var 属性：指定一个存储结果的变量名。
        scope 属性：将变量存储在哪个作用域（page，request，session，application）。
    --%>
    <h3>num 是否小于 10：${result}</h3>


    <!-- 多条件判断 --%>
    <c:choose>
        <c:when test="${num > 10}">
            <h3>num 大于 10</h3>
        </c:when>
        <c:when test="${num < 10}">
            <h3>num 小于 10</h3>
        </c:when>
        <c:otherwise>
            <h3>num 等于 10</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>