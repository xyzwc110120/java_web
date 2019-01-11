<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/filter/login" method="post">
        <label>
            账号：<input name="account" type="text" required>
        </label>
        <label>
            密码：<input name="password" type="text" required>
        </label>

        <input type="submit" value="提交">
    </form>
</body>
</html>
