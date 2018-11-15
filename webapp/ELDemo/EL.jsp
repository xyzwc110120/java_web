<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EL</title>
</head>
<body>
    <%
        // JSP 的四大作用域
        /* 这里要注意：需要引入 javax.servlet.jsp-api 这个 jar 包，不然会报错找不到该方法 */
        // pageContext.setAttribute("msg", "pageContextValue");
        // request.setAttribute("msg", "requestValue");
        session.setAttribute("msg", "sessionValue");
        application.setAttribute("msg", "applicationValue");

    %>
    <h1>获取每一个作用域中的数据：</h1>
    <h3>pageContext：<%= pageContext.getAttribute("msg") %></h3>
    <h3>request：<%= request.getAttribute("msg") %></h3>
    <h3>session：<%= session.getAttribute("msg") %></h3>
    <h3>application：<%= application.getAttribute("msg") %></h3>
    <br><br>

    <h1>pageContext 中的 findAttribute 方法：</h1>
    <%-- 该方法会按照作用域由小到大获取指定属性名的值（顺序为：page（pageContext），request，session，application） --%>
    <h3>findAttribute 方法：<%= pageContext.findAttribute("msg") %></h3>
    <br><br>

    <h1>使用 EL</h1>
    <h3>EL：${msg}</h3>
    <%-- 该表达式相当于下面方法 --%>
    <%= pageContext.findAttribute("msg") == null ? "" : pageContext.findAttribute("msg") %>
</body>
</html>