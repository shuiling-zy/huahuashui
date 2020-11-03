<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/10/29
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="VerificationServlet" method="post">
  邮箱: <input type="text" name="email" /><br>
  密码: <input type="password" name="password" /><br>
  验证码: <input type="text" name="code" /><br>
  <input type="submit" value="注册">
</form>
</body>
</html>
