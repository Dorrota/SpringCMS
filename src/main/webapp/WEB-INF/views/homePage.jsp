<%--
  Created by IntelliJ IDEA.
  User: Dorota
  Date: 21/05/2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<table>
<tbody>
<c:forEach items="${articles}" var="art">
    <tr>
        <td><c:out value="${art.title}"/></td>
        <td><c:out value="${art.created}"/></td>
        <td><c:out value="${art.author.firstName}"/></td>
        <td>${fn:substring(art.content, 0, 11)}</td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
