<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 10/2/14
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/decorator/navigationBar.jsp" %>
    ${post.user.firstName} Wrote at ${post.date}
    <br>
    ${post.body}
    <br>
    Comments
    <c:forEach items="${post.comments}" var="comment">
        <br>
        ${comment.commentBody}
    </c:forEach>

    <br>
    Add new comment
    <form action="/posts/${post.postId}/comment" method="post">
        <input type="text" name="comment-text">
        <input type="submit" style="visibility: hidden">
    </form>
<%@ include file="/WEB-INF/decorator/bootstrap-scripts.jsp"%>
</body>
</html>
