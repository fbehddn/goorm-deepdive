<%--
  Created by IntelliJ IDEA.
  User: sisim
  Date: 2024-09-05
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form action="/user/login" method="post">
    이메일 : <input type="text" name="email" /><br>
    비밀번호 : <input type="password" name="password" /> <br>
    <button type="submit">로그인</button>
</form>

<h2>${message}</h2>
</body>
</html>