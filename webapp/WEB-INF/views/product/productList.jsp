<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <h1>商品列表：</h1>
    <a href="${pageContext.request.contextPath}/product?opt=edit">添加</a>
    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr>
            <th>商品名称</th>
            <th>商品品牌</th>
            <th>商品进价</th>
            <th>商品原价</th>
            <th>商品现价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${products}" var="product" varStatus="status">
        <tr <c:if test="${status.count % 2 == 0}">style="background-color: aquamarine" </c:if>>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.purchasingPrice}</td>
                <td>${product.originalPrice}</td>
                <td>${product.currentPrice}</td>
                <td>
                    &nbsp;
                    <a href="${pageContext.request.contextPath}/product?opt=delete&id=${product.id}">删除</a>
                    &nbsp;|&nbsp;
                    <a href="${pageContext.request.contextPath}/product?opt=edit&id=${product.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>