<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>监听器测试</title>
</head>
<body>
    Hello

    <%
        session.setAttribute("like", "可乐");
        session.setAttribute("hate", "牛奶");
        session.removeAttribute("hate");
        session.setAttribute("like", "白开水");
    %>
</body>
</html>
