<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 30.04.2022
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="2" step="2" end="10" var="number">
    ${number} <br>
</c:forEach>
</body>
</html>
