<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 导入国际化标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>date</title>
</head>
<body>
    <% pageContext.setAttribute("time", new java.util.Date()); %>
    <!-- 时间格式化 -->
    <h3>现在时间：<fmt:formatDate value="${time}" pattern="yyyy-MM-dd HH:mm:ss" /></h3>
</body>
</html>