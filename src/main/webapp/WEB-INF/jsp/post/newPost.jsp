<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 10/1/14
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="/WEB-INF/decorator/navigationBar.jsp"%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8">
                <form role="form" method="post" action="/posts/newPost">
                    <div class="form-group">
                        <label for="inputText">What's you want to roar about?</label>
                        <textarea style="vertical-align: middle" id="inputText" class="form-control" name="post-text" placeholder="What's on your mind?"></textarea>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>">
                </form>
            </div>
            <div class="col-md-2">

            </div>
        </div>

    </div>
    <%@include file="/WEB-INF/decorator/bootstrap-scripts.jsp"%>
</body>
</html>
