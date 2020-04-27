<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resources/css/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="container">

    <form:form method="POST" modelAttribute="userForm" enctype="multipart/form-data" class="form-signin" >
        <h2 class="form-signin-heading">Створіть свій аккаунт</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Логін"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control"
                            placeholder="Ім'я"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control"
                            placeholder="Прізвище"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" path="email" class="form-control"
                            placeholder="email"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Пароль"></form:input>
            <form:errors path="password"></form:errors>
        </div>
        </spring:bind>


        <spring:bind path="avatar" >
            <h5><label>Ваше фото</label></h5>
                <form:input  type="file"  path="avatar" class="form-control" placeholder="Avatar"></form:input>
        </spring:bind>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><h4>Зареєструватись</h4></button>
    </form:form>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>