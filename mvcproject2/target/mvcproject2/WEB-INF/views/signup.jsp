<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: youdong-u
  Date: 9/3/24
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup Form</title>
</head>
<body>
    <form:form modelAttribute="user">
        이름 : <form:input path="name"/><br>
        이메일 : <form:input path="email"/><br>
        비밀번호 :<form:password path="password"/><br>
        나이 : <form:input path="age"/><br>
    </form:form>
</body>
</html>
