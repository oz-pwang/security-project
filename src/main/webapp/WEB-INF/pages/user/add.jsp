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
    <title>添加</title>

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

    <jsp:include page="../common/navbar.jsp"/>

    <div class="well">
        <h1 class="text-center">
                                   <%--ne 是什么意思？--%>
            <c:if test="${user.id ne null}">
                编辑用户
            </c:if> <c:if test="${user.id eq null}">
            添加用户
        </c:if>
        </h1>
        <form:form action="/user/add" method="post" cssClass="form-horizontal" commandName="command">
            <form:hidden path="id"/>

            <%--// 1. spring:bind 检查表单验证结果，将path的验证结果绑定到${status}对象上--%>
            <spring:bind path="username">
                <%--// 2.${status.error}检查是否存在表单验证不通过 --%>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="username" class="col-sm-2 control-label">Username</label>

                    <div class="col-sm-10">
                        <%--                                                                         //默认输入框里存在的值，当开始输入时自动清除--%>
                        <form:input id="username" path="username" cssClass="form-control" placeholder="Username"
                                    required="true"/>
                            <%--// 3.输出验证错误信息 --%>
                        <form:errors path="username" cssClass="alert-danger" element="div"/>
                    </div>

                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="password" class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-10">
                        <form:password id="password" path="password" cssClass="form-control" placeholder="Password"
                                       required="true"/>
                        <form:errors path="password" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="gender">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="gender" class="col-sm-2 control-label">Gender</label>

                    <div class="col-sm-10">
                        <div class="radio">
                            <label>
                                <form:radiobutton path="gender" value="male"/>男
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <form:radiobutton path="gender" value="female"/>女
                            </label>
                        </div>

                        <form:errors path="gender" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="age">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="age" class="col-sm-2 control-label">Age</label>

                    <div class="col-sm-10">
                        <form:input id="age" path="age" cssClass="form-control" placeholder="Age" type="number"/>
                        <form:errors path="age" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="birthDateString">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="birthDateString" class="col-sm-2 control-label">Birth Date</label>

                    <div class="col-sm-10">
                        <form:input id="birthDateString" path="birthDateString" cssClass="form-control"
                                    placeholder="1900-12-29"
                                    type="datetime"/>
                        <form:errors path="birthDateString" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="email" class="col-sm-2 control-label">Email</label>

                    <div class="col-sm-10">
                        <form:input id="email" path="email" cssClass="form-control" placeholder="username@mail.com"
                                    type="email"/>
                        <form:errors path="email" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="phoneNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>

                    <div class="col-sm-10">
                        <form:input id="phoneNumber" path="phoneNumber" cssClass="form-control" placeholder="phone"
                                    type="number"/>
                        <form:errors path="phoneNumber" cssClass="alert-danger" element="div"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <label for="photo" class="col-sm-2 control-label">Choose a picture</label>

                <div class="col-sm-10">
                    <input type="file" id="photo" name="photo">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>
