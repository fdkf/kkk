<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/21
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/bootstrap/bootstrap/js/jquery/2.0.0/jquery.min.js">
    </script>
    <script>
        function c() {
            var flag = $("#auto").prop("checked");//是否
            if(flag){//true
                var  username=$("#username").val();
                alert(username);
                var  password=$("#password").val();
                alert(password);
                if(username!='' && password!=''){
                    alert(flag);
                    //后端发送请求
                    location.href="${pageContext.request.contextPath}/Showusername?f="+flag+"&username="+username+"&password="+password;

                //    location.href="${pageContext.request.contextPath}/Showusername?f="+flag+"&username="+username+"&password="+password;
                }
            }
        }
    </script>
</head>
<body>
<%
String username ="";String password = "";String  flag = "";//对于cookie，最好用String类型的
Cookie[] cookies=request.getCookies();
    for (int i = 0; i <cookies.length ; i++) {
        if(cookies[i].getName().equals("username")){
            username= cookies[i].getValue();
        }
        if(cookies[i].getName().equals("password")){
            password =cookies[i].getValue();
        }
        if(cookies[i].getName().equals("flag")){
            flag=cookies[i].getValue();
            System.out.println("jsp的flag"+flag);
        }
    }
%>
<c:if test="${sessionScope.u == null}">${message}</c:if>
<center>
    <h3>欢迎登陆</h3>
<form  method="post" action="${pageContext.request.contextPath}/Showusername" id="f" >
<%--@declare id="name"--%>
<label for="name">账号:</label>
    <input type="text" name="username" id="username" value="<%=username%>"><br>
<label for="name">密码:</label>
<input type="password" name="password" id="password" value="<%=password%>" ><br><br>
    <button type="submit" onclick="c()" >登录</button>
    <input type="checkbox" id="auto" <c:if test="${flag eq true}">checked</c:if>  >自动登录</input>
    <a href="ZhuCe.jsp">注册</a>
</form>
</center>

</body>
</html>
