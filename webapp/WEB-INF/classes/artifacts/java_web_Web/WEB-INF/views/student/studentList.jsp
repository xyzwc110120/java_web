<%@ page import="java.util.List" %>
<%@ page import="com.cyx.java_web.web_01_servlet.servlet_17_student.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
    <h1>学生列表</h1>
    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <%
            /* 获取请求对象中的参数 */
            List<Student> students = (List<Student>) request.getAttribute("students");
            /* 遍历集合 */
            for (Student student : students) {
        %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getAge() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
