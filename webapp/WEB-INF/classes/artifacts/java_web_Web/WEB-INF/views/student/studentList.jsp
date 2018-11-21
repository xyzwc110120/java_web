<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
    将 JSP 页面放在 WEB-INF 目录中，是因为 WEB-INF 目录是受保护目录，外界不可以直接访问， 这样就可以避免外界通过地址拼接直接访问页面。
--%>

<html>
<head>
    <title>学生列表</title>
</head>
<body>
    <h1>学生列表</h1>
    <a href="#">添加</a>
    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr style="background-color: cadetblue">
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="vs">
            <%--
                varStatus 属性：迭代状态：
                    varStatus.count 当前迭代第几个元素。
                    varStatus.index 当前迭代的元素的索引。
            --%>
            <!-- 若当前迭代的是第偶数个元素，则修改该行背景色 -->
            <tr style="background-color: ${vs.count % 2 == 0 ? 'aqua' : ''}">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/java_web/student/delete?id=${student.id}">删除</a>&nbsp;|&nbsp;
                    <a href="#">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
