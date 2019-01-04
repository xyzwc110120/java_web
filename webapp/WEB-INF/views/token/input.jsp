<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>解决表单的重复提交</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/token/submit" method="post">
    <%-- 请求时需要验证的令牌 --%>
    <input name="token" value="${token}" hidden>

    <label>转账金额：
        <input name="money" type="number" required>
    </label><br>

    <input type="submit" name="提交">
</form>
</body>
</html>