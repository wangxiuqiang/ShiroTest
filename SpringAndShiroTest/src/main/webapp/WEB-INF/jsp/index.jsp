<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 17-12-4
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
${no}
   <form method="post" action="${pageContext.request.contextPath}/login">
       用户名:<input name="name" type="text" >
       密码: <input name="password" type="password" />
       <input type="submit" value="登录" />
   </form>
</body>
</html>
