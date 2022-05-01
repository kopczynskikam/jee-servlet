<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 30.04.2022
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/newsletter" method="post">
    <input type="text" name="email" placeholder="email:"> <br>
    <input type="text" name="name" placeholder="Imię i nazwisko:"> <br>
    <input type="submit" value="wyślij"> <br>
</form>
<a href="http://localhost:8080/newsletter">Wróć do artykułu</a>
</body>
</html>
