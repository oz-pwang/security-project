<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 8/15/15
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>登录</title>

  <!-- Bootstrap -->
  <link href="<c:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

<div class="container">
  <div class="clearfix">&nbsp;</div>
  <div class="clearfix">&nbsp;</div>
  <div class="well">
    <h1 class="text-center">登录</h1>

    <c:if test="${param.failed eq 'true'}">
      <div class="alert alert-danger" role="alert">
        Username or password is not match.
      </div>
    </c:if>

    <form action="<c:url value='/j_spring_security_check' />" method="post" class="form-horizontal">
      <div class="form-group">
        <label for="username" class="col-sm-2 control-label">Username</label>

        <div class="col-sm-10">
          <input id="username" type="text" name="username" class="form-control" placeholder="Username">
        </div>
      </div>

      <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>

        <div class="col-sm-10">
          <input id="password" type="password" name="password" class="form-control" placeholder="Password">
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">Sign in</button>
        </div>
      </div>
    </form>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
