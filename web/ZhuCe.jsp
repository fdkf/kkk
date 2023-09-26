<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<center>
    <h3>请注册:</h3>
    <form method="get" action="ZhuCe">
        <%--@declare id="name"--%>
        <label for="name">新的账号:</label>
        <input type="text" name="username" required><br><br>
        <label for="name">新的密码:</label>
        <input type="password" name="password" required><br><br>
        <button type="submit"  >注册</button>
        </button>
    </form>
</center>
</body>
</html>
