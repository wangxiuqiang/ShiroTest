<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 17-11-29
  Time: 下午5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>成功登录</title>
</head>
<body>
${info}
<br/>
欢迎登录
<shiro:hasRole name="admin">
    有admin角色的suject  <shiro:principal/>
</shiro:hasRole>
<shiro:hasPermission name="student:add">
    有student:add权限的subject<shiro:principal/>
</shiro:hasPermission>
</body>
</html>
