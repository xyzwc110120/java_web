<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>学生信息表</title>
</head>
<body>
    <h3>学生表单：</h3>
    <form action="${pageContext.request.contextPath}/student/merge" method="post">
        <input hidden name="id" value="${student.id}">
        <input hidden name="opt" value="save">
        <label>姓名：
            <input type="text" required name="name" value="${student.name}">
        </label>
        <br>
        <label>年龄：
            <input type="number" required name="age" value="${student.age}">
        </label>
        <br>

        <input type="submit" value="提交">
    </form>
</body>
</html>