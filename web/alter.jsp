<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/15
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<h4>根据员工编号进行修改</h4>
<form method="post" action="AlterServlet" enctype="multipart/form-data">
    <!--对于文件上传需要一定是post方式，同时添加enctype属性-->

    <table align="center" border="1px">
        <%--@declare id="name"--%>
            <label for="name">员工编号:</label>
        <input type="text" id="empno" name="empno" value="${requestScope.emp.empno}" required><br><br>
        <label for="name">姓名:</label>
        <input type="text" id="ename" name="ename" value="${requestScope.emp.ename}" required><br><br>
        <label for="name">部门编号</label>
        <input type="text" id="deptno" name="deptno" value="${requestScope.emp.deptno}" required><br><br>
        <label for="name">职位:</label>
        <input type="text" id="job" name="job" value="${requestScope.emp.job}" required><br><br>
        <label for="name">工资:</label>
        <input type="text" id="sal" name="sal" value="${requestScope.emp.sal}" required><br><br>
        <label for="name">出生日期:</label>
        <input type="text" id="brith" name="brith" value="${requestScope.emp.brith}" required>
        <label for="name">上传头像:</label>
        <input type="file" name="file">
            <input  type="reset" value="重置">
        <input type="submit" value="提交">
    </table>
</form>
</body>
</html>
