<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品编辑</title>
</head>
<body>
    <h1>商品编辑</h1>
    <form action="${pageContext.request.contextPath}/product?opt=save" method="post">
        <input hidden name="id" value="${product.id}">
        <input hidden name="opt" value="save">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td>商品类型：</td>
                <td>
                    <select name="productTypeId">
                        <c:forEach items="${productTypes}" var="type">
                            <option value="${type.id}" <c:if test="${product.productTypeId eq type.id}">selected</c:if>>${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>商品名称：</td>
                <td><input type="text" name="name" value="${product.name}" required></td>
            </tr>
            <tr>
                <td>商品品牌：</td>
                <td><input type="text" name="brand" value="${product.brand}" required></td>
            </tr>
            <tr>
                <td>商品进价：</td>
                <td><input type="number" name="purchasingPrice" value="${product.purchasingPrice}" required min="0"></td>
            </tr>
            <tr>
                <td>商品原价：</td>
                <td><input type="number" name="originalPrice" value="${product.originalPrice}" required min="0"></td>
            </tr>
            <tr>
                <td>商品现价：</td>
                <td><input type="number" name="currentPrice" value="${product.currentPrice}" required min="0"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>