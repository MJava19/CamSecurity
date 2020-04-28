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
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>

            <form:form  action="/goods/update"  method="POST" modelAttribute="goods" enctype="multipart/form-data" class="forms">
                <input type="hidden" value="${goods.id}" class="form-control" id="id" name="id">
                <spring:bind path="name" >
                    <h3><label>Код товару:</label></h3>
                    <form:input  type="text"  path="code" class="form-control form-control-lg"  id="code" name="code"></form:input>
                </spring:bind>

                <spring:bind path="name" >
                    <h3><label>Назва товару:</label></h3>
                    <form:input  type="text"  path="name" class="form-control form-control-lg"  id="name" name="name"></form:input>
                </spring:bind>

                <spring:bind path="description" >
                    <h3><label>Опис товару:</label></h3>
                    <form:textarea type="text"  path="description" class="form-control form-control-lg"  id="description" name="description"></form:textarea>
                </spring:bind>

                <spring:bind path="manufacturer" >
                    <h3><label>Виробник товару:</label></h3>
                    <form:input  type="text"  path="manufacturer" class="form-control form-control-lg"  id="manufacturer" name="manufacturer"></form:input>
                </spring:bind>

                <spring:bind path="price" >
                    <h3><label>Ціна товару:</label></h3>
                    <form:input  type="number"  path="price" class="form-control form-control-lg"  id="price" name="price"></form:input>
                </spring:bind>

                <spring:bind path="group" >
                    <h3><label>Категорія товару:</label></h3>
                    <select  name="group" class="form-control form-control-lg" >
                        <option value="" disabled selected><h3>Оберіть категорію для товару</h3></option>
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </spring:bind>

                <spring:bind path="image" >
                    <h3><label>Фото товару:</label></h3>
                    <form:input  type="file" multiple = "multiple" path="image" class="form-control form-control-lg" placeholder="Image" ></form:input>
                </spring:bind>
                <br>
                <button type="submit" class="btn btn-danger"><h4>Оновити</h4></button>
                <a href="/goods" type="submit" class="btn btn-info"><h4>Повернутись до товарів</h4></a>
            </form:form>
</body>
</html>