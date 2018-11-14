<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
</head>
<body>
    <%--
        <%@include file="top.jsp"%><br>
        <h3>这是主页面</h3><br>
        <%@include file="foot.jsp"%>
    --%>

    <jsp:include page="top.jsp" /><br>
    <h3>这是主页面</h3><br>
    <jsp:include page="foot.jsp">
        <%-- 使用动态包含可以传递参数 --%>
        <jsp:param name="" value="" />
    </jsp:include>
</body>
</html>