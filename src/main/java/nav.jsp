<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ozintel06
  Date: 16/8/15
  Time: 下午11:10
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">商城主页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="<c:url value="/j_spring_security_logout" />">注销</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="navbar-brand"></li>
      </ul>
      <%--<c:if test="${pageContext.request.userPrincipal.name ne null}">--%>
      <ul class="nav navbar-nav navbar-right">
        <li class="active">
          <a href="<c:url value="login"/>">eeee</a>
        </li>
      </ul>
      <%--</c:if>--%>
      <%--<c:if test="${pageContext.request.userPrincipal.name eq null}">--%>
      <%--<ul class="nav navbar-nav navbar-right">--%>
      <%--<li class="active"><a href="<c:url value="/login" />">登录</a></li>--%>
      <%--</ul>--%>
      <%--</c:if>--%>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>