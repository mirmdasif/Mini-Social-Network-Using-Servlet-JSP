
<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 10/1/14
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/decorator/navigationBar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">

            <c:forEach items="${requestScope.posts}" var="post">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <p>${post.body}</p>
                        <a href="posts/${post.postId}">Add Comment</a>

                    </div>
                </div>

            </c:forEach>
        </div>
        <div class="col-md-3"></div>
    </div>


</div>

<%@ include file="/WEB-INF/decorator/bootstrap-scripts.jsp"%>
</body>
</html>
