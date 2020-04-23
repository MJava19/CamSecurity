<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Update goods</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <form:form  action="/goods/update"  method="POST" modelAttribute="goods" enctype="multipart/form-data">
                <input type="hidden" value="${goods.id}" class="form-control" id="id" name="id">
                <spring:bind path="name" >
                    <label>Goods code:</label>
                    <form:input  type="number"  path="code" class="form-control"  id="code" name="code"></form:input>
                </spring:bind>

                <spring:bind path="name" >
                    <label>Goods name:</label>
                    <form:input  type="text"  path="name" class="form-control"  id="name" name="name"></form:input>
                </spring:bind>

                <spring:bind path="description" >
                    <label>Goods description:</label>
                    <form:input  type="text"  path="description" class="form-control"  id="description" name="description"></form:input>
                </spring:bind>

                <spring:bind path="price" >
                    <label>Goods price:</label>
                    <form:input  type="number"  path="price" class="form-control"  id="price" name="price"></form:input>
                </spring:bind>

                <spring:bind path="group" >
                    <select  name="group" >
                        <option value="" disabled selected>Choose group goods</option>
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </spring:bind>

                <spring:bind path="image" >
                    <label>Goods photo:</label>
                    <form:input  type="file" multiple = "multiple" path="image" class="form-control" placeholder="Image" ></form:input>
                </spring:bind>
                <br>
                <button type="submit" class="btn btn-default">Update</button>
                <a href="/goods" type="submit" class="btn btn-info">Back to goods</a>
            </form:form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>