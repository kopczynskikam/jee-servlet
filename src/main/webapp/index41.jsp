<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 30.04.2022
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String author = request.getParameter("author");
    if(author!=null && !author.equals("")){
        response.getWriter().append("<p>Wybrany autor: ").append(author + "<p>");
    }
%>
</body>
</html>
