<%--
  Created by IntelliJ IDEA.
  User: youdong-u
  Date: 9/5/24
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>Quiz Question ${question.questionNum}</h1>
<p>${question.questionContent}</p>

<form action="/quiz" method="post">
    <input type="text" name="answer" required/>
    <button type="submit">Submit Answer</button>
</form>
</body>
</html>

