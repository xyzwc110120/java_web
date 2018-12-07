<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <span style="color: red;">${errorMsg}</span>
    <%--
        1、使用文件上传空间，表单的提交方式必须为 post 方式，因为 get 方式传输数据大小受限；
        2、上传控件的使用 type 为 file 类型（type="file"）；
        3、enctype 属性规定在将表单数据发送到服务器之前如何对其进行编码：
            multipart/form-data	不对字符编码。当使用有文件上传控件的表单时，该值是必需的。
     --%>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
        <label>昵称：<input type="text" name="nickname"></label><br>
        <label>邮箱：<input type="text" name="email"></label><br>
        <label>头像：<input type="file" name="head" accept="image/*"></label><br>
        <%--
            accept 属性 (文件上传类型控制)：
                accept 属性规定了可通过文件上传提交的服务器接受的文件类型。
                注意：accept 属性仅适用于 <input type="file">。
                提示：请不要将该属性作为您的验证工具。应该在服务器上对文件上传进行验证（因为还是可以选择所有文件）。
        --%>
        <input type="submit" value="注册">
    </form>
</body>
</html>