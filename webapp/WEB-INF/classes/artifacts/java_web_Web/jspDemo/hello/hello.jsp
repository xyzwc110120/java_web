<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <%-- 在 <%=%> 中编写 Java 代码 --%>
    <h1>北京时间：<%= new java.util.Date().toLocaleString() %></h1>
</body>
</html>