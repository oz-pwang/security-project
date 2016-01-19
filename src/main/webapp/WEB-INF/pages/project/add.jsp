<%--
  Created by IntelliJ IDEA.
  User: Yang Wang
  Date: 8/15/15
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>添加Project</title>

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

<jsp:include page="../common/navbar.jsp"/>

<div class="well">
    <h1 class="text-center">
        <%--ne 是什么意思？--%>
        <c:if test="${user.id ne null}">
            编辑Project
        </c:if>
        <c:if test="${user.id eq null}">
            添加Project
        </c:if>
    </h1>
    <form:form action="/project/add" method="post" cssClass="form-horizontal" commandName="projectCommand">
        <%--<form:hidden path="id"/>--%>

        <spring:bind path="projectName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="projectName" class="col-sm-2 control-label">projectName</label>

                <div class="col-sm-10">
                    <form:input id="projectName" path="projectName" cssClass="form-control" placeholder="projectName"
                                required="true"/>
                    <form:errors path="projectName" cssClass="alert-danger" element="div"/>
                </div>

            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Create project</button>
            </div>
        </div>
    </form:form>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
