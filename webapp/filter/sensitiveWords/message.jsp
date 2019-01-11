<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>提交信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/filter/message" method="post">
        <label>
            信息：<textarea name="message" required rows="3" cols="20" ></textarea>
        </label>

        <input type="submit" value="提交">
    </form>
</body>
</html>
