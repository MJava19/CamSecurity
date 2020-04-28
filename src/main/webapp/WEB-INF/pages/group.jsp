<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>

<form:form action="/groups/create" method="POST" modelAttribute="group" enctype="multipart/form-data" class=" forms ">
    <input type="hidden" value="${group.id}" class="form-control" id="id" name="id">
    <div class="form-group">
        <h3><label>Назва групи:</label></h3>


        <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" class="form-control form-control-lg" id="name" name="name"
                        value="${group.name}" path="name"></form:input>
            <form:errors path="name"></form:errors>
        </div>
        </spring:bind>


        <br>
        <h3><label>Опис групи:</label></h3>
        <spring:bind path="description">
                <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:textarea type="text" class="form-control form-control-lg" id="description" path="description" name="description"
                           value="${group.description}"></form:textarea>
                    <form:errors path="description"></form:errors>
                </div>
        </spring:bind>


        <br>
        <h3><label>Картинка крупи:</label></h3>
        <spring:bind path="avatar">
                <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="file"  path="avatar" class="form-control form-control-lg" placeholder="Avatar"></form:input>
                    <form:errors path="avatar"></form:errors>
                </div>
        </spring:bind>
    </div>
    <button type="submit" class="btn  btn-danger "><h4>Створити</h4></button>
    <a href="/groups" type="submit" class="btn btn-info "><h4>Повернутись до категорій</h4></a>
</form:form>