<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登陆</title>

    <script>
        function change() {
            // 获取指定 id 的元素，并修改属性
            document.getElementById("img").src = "${pageContext.request.contextPath}/verificationCode?date=" + new Date().getTime();
            // 因为每次请求都是同一地址，浏览器会将之前请求时获得的响应数据直接从缓存中拿来使用，所以要在后面加上参数，使每次请求不同
        }
    </script>
</head>
<body>
    <h3>登陆</h3>
    <span style="color: red;">${errorMsg}</span>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>账&nbsp;号：
            <input type="text" name="account" required>
        </label><br>
        <label>密&nbsp;码：
            <input type="password" name="password" required>
        </label><br>
        <label>验证码：
            <input type="text" name="verificationCode" size="4" required>
            <%-- 网页获取图片会去请求 src 属性中的地址 --%>
            <img src="${pageContext.request.contextPath}/verificationCode" id="img" title="看不清，换一张" alt="请刷新"
                 style="cursor: pointer;" onclick="change()">
        </label><br>

        <input type="submit" value="登陆">
    </form>
</body>
</html>