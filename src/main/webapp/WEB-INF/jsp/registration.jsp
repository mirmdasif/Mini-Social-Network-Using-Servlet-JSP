<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 10/1/14
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

</head>
<body>
<div class="container-fluid">
    <form class="form-signin" role="form" action="/registration" method="post">
        <h2 class="form-signin-heading">Signup Here</h2>
        <input type="text" class="form-control" placeholder="First Name" name="firstName" required>
        <br>
        <input type="text" class="form-control" placeholder="Last Name" name="lastName" required>
        <br>
        <input type="text" type="email" class="form-control" placeholder="example@example.com" name="email" equired autofocus>
        <br>
        <input type="password" class="form-control" placeholder="Password" required name="password">
        <br>
        <input type="submit" style="visibility: hidden">
    </form>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
