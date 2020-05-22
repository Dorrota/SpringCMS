<%--
  Created by IntelliJ IDEA.
  User: Dorota
  Date: 22/05/2020
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<table>
    <tbody>
    <c:forEach items="${categories}" var="cat">
        <tr>
            <td><c:out value="${cat.name}"/></td>
            <td><c:out value="${cat.description}"/></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
