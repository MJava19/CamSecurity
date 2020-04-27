
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>
            <c:forEach items="${group}" var="group">
            <div class="card" >
                    <img class="card-img-top" width="500px" height="200px" src="data:image/png;base64,<c:out value='${group.base64}'/>" alt="Group Image">
                <div class="card-body">
                    <h4 class="card-title">${group.name}</h4>
                   <h5> <p class="card-text">${group.description}</p></h5>
                    <h5><b>Кількість товарів: ${group.totalGoods}</b></h5>
                    <a href="/groups/list/goods?id=${group.id}" class="btn marge btn-primary"><h5>Переглянути товари</h5></a>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/groups/one?id=${group.id}" class="btn marge btn-danger"><h5>Редагувати категорію</h5></a>
                    <a href="/groups/delete?id=${group.id}" class="btn marge btn-danger"><h5>Видалити категорію</h5></a>
                    </sec:authorize>
                </div>
            </div>
            </c:forEach>