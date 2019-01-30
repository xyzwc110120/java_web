<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>foreach</title>
</head>
<body>
    <!-- 需求 1：从 1 输出到 10 -->
    <c:forEach var="num" begin="10" end="1" step="-1">
        <%--
            这里注意，其实在遍历内部，每次遍历都有执行：pageContext.setAttribute("num", num);方法 ，
            所以我们才可以在遍历中从作用域中通过变量名获取到遍历的元素值。
        --%>
        <h3>${num}</h3>
    </c:forEach>
    <%--
        var 属性：为遍历中的元素指定一个属性名。
        bigin 属性：起始值。
        end 属性：结束值。
        step 属性：步长，每次增长值。
    --%>


    <!-- 需求 2：迭代一个集合中的所有数据 -->
    <% pageContext.setAttribute("list", java.util.Arrays.asList("A", "B", "C", "D")); %>;
    <c:forEach items="${list}" var="list">
        <%-- 这里在底层其实也使用了：pageContext.setAttribute("list", list);方法。 --%>
        <h3>${list}</h3>
    </c:forEach>
    <%--
        items 属性：对哪一个集合做迭代（获取作用域中的数据，别忘记使用 EL 表达式）。
        var 属性：为集合中迭代的每个元素指定一个变量名。
    --%>
</body>
</html>
