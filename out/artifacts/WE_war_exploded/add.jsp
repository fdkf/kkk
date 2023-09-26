<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/14
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
<head>
    <title>添加信息</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/bootstrap/bootstrap/js/jquery/2.0.0/jquery.min.js">
    </script>
    <script type="text/javascript">
        var  f;
        /*定义函数  checkName*/
        function checkName() {
            //1 获取框中中
            var   empno=$("#empno").val();
            //2 uname去数据库查询   看看有没有
            //ajax  异步请求:局部刷新    整个页面不会提交  只实现局部发送请求
            //url:请求发送地址 type：请求方式 data：数据   dataType：数据类型 success：成功  回调
            if(empno!=''){
                $.ajax({
                    url:'${pageContext.request.contextPath}/ShownameServlet',
                    type:'post',
                    data:{"empno":empno},
                    dataType:'text',
                    success:function (result) {//回调函数   result就是后端响应的数据
                        if(result == 'ok'){
                            $("#s").html("<font color='blue'>用户名可用</font>");
                            f=true;
                        }if (result == 'no'){
                            $("#s").html("<font color='blue'>用户名不可用</font>");
                            f=false;
                        }
                    },error:function () {
                        console.log("异步请求失败");
                    }
                });

            }

        }
        function c() {
               return f;
        }
    </script>
</head>
<body>
<form method="post" action="AdddServlet" enctype="multipart/form-data" onsubmit="return  c();">
    <table align="center" border="1px">
<%--@declare id="name"--%>
    <label for="name">员工编号:</label>
    <input type="text" id="empno" name="empno" onblur="checkName()" ><span id="s"></span><br><br>
    <label for="name">姓名:</label>
    <input type="text" id="ename" name="ename" required><br><br>
    <label for="name">部门编号</label>
    <input type="text" id="deptno" name="deptno" required><br><br>
    <label for="name">职位:</label>
    <input type="text" id="job" name="job" required><br><br>
    <label for="name">工资:</label>
    <input type="text" id="sal" name="sal" required><br><br>
    <label for="name">出生日期:</label>
    <input type="text" id="brith" name="brith" required>
    头像:<input type="file" name="file"><br/>
    <input type="submit" value="提交">
    </table>

</form>
</body>
</html>
