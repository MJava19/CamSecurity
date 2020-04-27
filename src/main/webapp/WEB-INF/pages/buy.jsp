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
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<body>

<div class="container">
    <jsp:include page="navbar.jsp"></jsp:include>
    <br>
    <br>

    <form:form method="POST" class="form-signin" modelAttribute="orderForm">
        <h2 class="form-heading">Оформлення доставки</h2>
        <br>
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="Ім'я"
                            autofocus="true"></form:input>
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


        <spring:bind path="fatherName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="fatherName" class="form-control"
                            placeholder="По-Батькові"></form:input>
                <form:errors path="fatherName"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" path="email" class="form-control"
                            placeholder="Email"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="phoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="phoneNumber" class="form-control" placeholder="Номер телефону"></form:input>
                <form:errors path="phoneNumber"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="region">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="region" class="form-control" placeholder="Область"></form:input>
                <form:errors path="region"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="city" class="form-control" placeholder="Місто"></form:input>
                <form:errors path="city"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="numberBranch">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="numberBranch" class="form-control" placeholder="Номер відділення Нової пошти"></form:input>
                <form:errors path="numberBranch"></form:errors>
            </div>
        </spring:bind>


        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Купити</button>
    </form:form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>