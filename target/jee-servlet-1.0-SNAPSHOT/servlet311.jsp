<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 30.04.2022
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${languageMap.get(layoutLanguage)}!
<form action="/servlet312" method="post">
    <select name="language">
        <c:forEach var="lang" items="${languageMap.keySet()}">
            <option value="${lang}">
                ${lang}
            </option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="ok">
</form>

</body>
</html>
