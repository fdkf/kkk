<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body><center>
<form method="post" action="After" enctype="multipart/form-data"><!--有文件的只能是post-->
    <input name="tid" value="${requestScope.shang.tid}" type="hidden">
    名称：<input type="text" name="tname" value="${requestScope.shang.tname}"><br>
    图片：<input type="file" name="file" ><br>
    日期：<input type="date" name="tdate" value="${requestScope.shang.tdate}"><br>
    <input type="submit" value="提交">

</form>
</center>
</body>
</html>
