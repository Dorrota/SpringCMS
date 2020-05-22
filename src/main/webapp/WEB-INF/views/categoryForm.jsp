<%--
  Created by IntelliJ IDEA.
  User: Dorota
  Date: 22/05/2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Category form</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:input path="name"/>
    <form:input path="description"/>
    <input type="submit">
</form:form>

</body>
</html>
