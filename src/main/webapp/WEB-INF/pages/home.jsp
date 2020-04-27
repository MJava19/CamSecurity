<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
<div class="container lk">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
        </form>

        <h2>Привіт, ${user.firstName} <img width="100px" height="100px" src="data:image/png;base64,<c:out value='${user.base64}'/>"/>
        </h2>
            <a type="button"
               class="btn btn-primary"  href="/user/edit" ><h4>Редагувати</h4></a>

    </c:if>
</div>
</body>
</html>


