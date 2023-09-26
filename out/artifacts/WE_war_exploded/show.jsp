<%@ page import="java.util.List" %>
<%@ page import="pojo.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/14
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>show</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap/css/bootstrap/3.3.6/bootstrap.css">
</head>
<body>
<center >
<%--表格--%>
    <h2 >员工信息</h2>
    -----------------------------------
    <%--@declare id="name"--%>
    <form method="get" action="${pageContext.request.contextPath}/CServlet">
    <label for="name">姓名:</label>
    <input type="text" name="ename" value="${sa.ename}"><br><br>
    <label for="name">出生日期:</label>
        <input type="date" name="date1"  placeholder="最小值"  value="<fmt:formatDate value='${sa.date1}' pattern='yyyy-MM-dd'></fmt:formatDate>"/>--
     <input type="date" name="date2"  placeholder="最大值" value="<fmt:formatDate value='${sa.date2}' pattern='yyyy-MM-dd'></fmt:formatDate>"/>
        部门:<select name="did">
        <option value="0">全体部门</option>
        <%--动态展示--%>
        <c:forEach  items="${depts}"  var="d">
            <option value="${d.deptno}"  <c:if test="${d.deptno==sa.did}">selected</c:if>>${d.dname}</option>
        </c:forEach>
    </select>
        <input  type="reset" value="重置">
    <input type="submit" value="搜索">
    </form>
    <table  class="table table-hover" >
    <tr>
        <th>批量删除</th>
        <th>部门编号</th>
        <th>姓名</th>
        <th>员工编号</th>
        <th>职位</th>
        <th>工资</th>
        <th>出生日期</th>
        <th>部门名称</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
<form action="Dels" method="post">
    <c:forEach items="${requestScope.page.list}" var="e">
        <tr>
            <td><input type="checkbox" value="${e.empno}" name="ids"></td>
            <td>${e.deptno}</td>
             <td>${e.ename}</td>
            <td>${e.empno}</td>
            <td>${e.job}</td>
            <td>${e.sal}</td>
            <td>${e.brith}</td>
            <td>${e.dname}</td>
            <td>
                <img src="${pageContext.request.contextPath}/IMG/${e.photo}" width="100px"  height="60px">
            </td>
            <td>
                <a href="DelServlet?empno=${e.empno}">删除</a>
                <a href="PreAlterServlet?empno=${e.empno}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <input type="submit" value="批量删除">
</form>
</table>
    <button  onclick="window.location.href='add.jsp'">添加</button>


    <!--分页-->
    <p >
        第${page.pageNo}页/共${page.pages}页  ${page.total}条记录

        <a href="CServlet?pno=1">首页</a>
        <c:if test="${page.pageNo>1}">
            <a href="CServlet?pno=${page.pageNo-1}">上一页</a>
        </c:if>
        <c:if test="${page.pageNo==1}">
            上一页
        </c:if>
        <c:if test="${page.pageNo<page.pages}">
            <a href="CServlet?pno=${page.pageNo+1}">下一页</a>
        </c:if>
        <c:if test="${page.pageNo>=page.pages}">
            下一页
        </c:if>
        <a href="CServlet?pno=${page.pages}">尾页</a>
    </p>

</center>
</body>
</html>
