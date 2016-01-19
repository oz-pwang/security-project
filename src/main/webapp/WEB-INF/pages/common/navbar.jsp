
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Static navbar -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PMS 1.0</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
             aria-expanded="false">User<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/user/add" />">Add User</a></li>
            <li><a href="<c:url value="/user/list" />">User List</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
             aria-expanded="false">Project<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/project/add" />">Add Project</a></li>
            <li><a href="<c:url value="/project/list" />">Project List</a></li>
          </ul>
        </li>
      </ul>
      <c:if test="${sessionScope.LoggedInUserID ne null}">
        <ul class="nav navbar-nav navbar-right">
          <li class="active"><a
                  href="<c:url value="/user/info?id=${sessionScope.LoggedInUserID}" />">${sessionScope.LoggedInUserName}</a>
          </li>
        </ul>
      </c:if>
      <c:if test="${sessionScope.LoggedInUserID eq null}">
        <ul class="nav navbar-nav navbar-right">
          <li class="active"><a href="<c:url value="/login" />">登录</a></li>
        </ul>
      </c:if>
    </div>
    <!--/.nav-collapse -->
  </div>
  <!--/.container-fluid -->
</nav>