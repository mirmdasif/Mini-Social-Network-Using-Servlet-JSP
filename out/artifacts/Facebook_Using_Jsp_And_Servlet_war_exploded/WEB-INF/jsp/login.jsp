<%--
  Created by IntelliJ IDEA.
  User: asif.hossain
  Date: 9/30/14
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <style type="text/css">
        body {
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color:#fff;
            background: #333 url('http://www.piccnys.com/wp-content/uploads/2013/11/Tiger-Roar-Images-1280x720.jpg') no-repeat fixed center center;
            font-family: 'Open Sans',Arial,Helvetica,Sans-Serif;
        }

    </style>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Roar</a>
        </div>
    </div>
</nav>
<%----%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-3">

        </div>
        <div class="col-md-3">

            <form class="form-horizontal" role="form" action="/login" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <div class="form-group">
                    <input name="email" type="email" class="form-control" placeholder="Email address" required autofocus>
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </div>
            </form>

            <form class="form-horizontal" role="form" action="/registration" method="post">
                <h2 class="form-signin-heading">Signup Here</h2>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="First Name" name="firstName" required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Last Name" name="lastName" required>
                </div>
                <div class="form-group">
                    <input type="text" type="email" class="form-control" placeholder="example@example.com" name="email" equired autofocus>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required name="password">
                </div>
                <div class="form-group">
                    <input type="submit" style="visibility: hidden">
                </div>
            </form>

            <a href="/registration">Register Here</a>
        </div>
        <div class="col-md-3">

        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
