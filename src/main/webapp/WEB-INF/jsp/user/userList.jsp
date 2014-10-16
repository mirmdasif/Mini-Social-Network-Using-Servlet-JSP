<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 10/1/14
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <table>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <a href="/users/${user.userId}">
                        ${user.firstName} ${user.lastName}
                </a>
                <br>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
