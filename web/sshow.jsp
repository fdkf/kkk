<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商品展示</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/bootstrap/bootstrap/js/jquery/2.0.0/jquery.min.js">
    </script>
    <script >
        function quan() {
            var cks =document.getElementsByName("idd");
            for (let i = 0; i <cks.length ; i++) {
                cks[i].checked=true;}}
        function fan() {
            var cks = document.getElementsByName("idd");
            for (let i = 0; i <cks.length ; i++) {
                if (cks[i].checked=true){
                    cks[i].checked=false;
                }
                else {cks[i].checked=true;}
            }}


    </script>

</head>
<body><center>
    <a href="">添加</a>
    <h3 align="right">欢迎${sessionScope.u.username}登录</h3>
    <form method="get" action="${pageContext.request.contextPath}/Shangpin" enctype="multipart/form-data">
        <%--@declare id="name"--%>
        <label for="name">商品名称:</label>
        <input type="text" name="tname" value="${shang.tname}"><br><br>
        <label for="name">生产日期:</label>
        <input type="date" name="date1"  placeholder="最小值"  value="<fmt:formatDate value='${shang.date1}' pattern='yyyy-MM-dd'></fmt:formatDate>"/>
        <input type="date" name="date2"  placeholder="最大值" value="<fmt:formatDate value='${shang.date2}' pattern='yyyy-MM-dd'></fmt:formatDate>"/>
        <input  type="reset" value="重置">
        <input type="submit" value="搜索">
            <input type="button" value="全选" onclick="quan()">
            <input type="button" value="反选" onclick="fan()">
    </form>


    <table border="2px" bgcolor="#ffe4c4">
        <tr>
            <th>批量删除</th>
            <th>编号</th>
            <th>名称</th>
            <th>图片</th>
            <th>日期</th>
            <th>修改</th>
            <th>选择</th>
        </tr>
        <form action="Delss" method="post">
            <c:forEach items="${requestScope.list}" var="e">
            <tr>
                <td><input type="checkbox" value="${e.tid}" name="ids"></td>
                <td>${e.tid}</td>
                <td>${e.tname}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/IMG/${e.timg}" width="100px"  height="60px">
                </td>
                <td>${e.tdate}</td>
                <td>
                    <a href="SPrealter?tid=${e.tid}">修改</a>
                </td>
                <td><input type="checkbox" value="${e.tid}" name="idd"></td>
            </tr>
            </c:forEach>
                <input type="submit" value="批量删除">

    </table>
    <p >
        第${page.pageNo}页/共${page.pages}页  ${page.total}条记录

        <a href="Shangpin?pno=1">首页</a>
        <c:if test="${page.pageNo>1}">
            <a href="Shangpin?pno=${page.pageNo-1}">上一页</a>
        </c:if>
        <c:if test="${page.pageNo==1}">
            上一页
        </c:if>
        <c:if test="${page.pageNo<page.pages}">
            <a href="Shangpin?pno=${page.pageNo+1}">下一页</a>
        </c:if>
        <c:if test="${page.pageNo>=page.pages}">
            下一页
        </c:if>
        <a href="Shangpin?pno=${page.pages}">尾页</a>
    </p>



</form>
</center>
</body>
</html>
