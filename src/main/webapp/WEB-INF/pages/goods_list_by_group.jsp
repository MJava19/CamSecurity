<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
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
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>
            <input type="hidden" value="${group.id}" class="form-control" id="id" name="id">
            <h1 class="dos">Category: ${groupName}</h1>
            <c:forEach items="${goods}" var="goods">
                <c:set var = "goods_id" value = "${goods.id}"/>
                <div class="card">
                    <div class="row ">
                        <div class="col-md-7 px-3">
                            <div class="card-block px-6">
                                <h4 class="card-title">${goods.name}</h4>
                                <p class="card-text">${goods.description}</p>
                                <br>
                                <h4 class="card-title">Виробник товару: ${goods.manufacturer}</h4>
                                <br>
                                <h4 class="card-title">Код товару: ${goods.code}</h4>
                                <a href="/basket?id=${goods_id}" class="mt-auto btn btn-primary">Додати в кошик</a>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/goods/one?id=${goods_id}" class="mt-auto btn btn-danger">Редагувати</a>
                                <a href="/goods/delete?id=${goods_id}" class="mt-auto btn btn-danger">Видалити</a>
                                </sec:authorize>
                            </div>
                        </div>
                        <div class="col-md-5">

                            <div id="God" class="carousel slide" data-ride="carousel">

                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <c:forEach items="${goods.image}"  begin="0" end="0" var="goods_s">
                                            <img class="d-block" width="400px" height="400px" src="data:image/png;base64,<c:out value='${goods_s.base64image}'/>" alt="">
                                        </c:forEach>
                                    </div>
                                    <c:forEach items="${goods.image}" begin="1" var="goods">
                                        <div class="carousel-item">
                                            <img class="d-block" width="300px" height="300px" src="data:image/png;base64,<c:out value='${goods.base64image}'/>" alt="">
                                        </div>
                                    </c:forEach>
                                    <a class="carousel-control-prev" href="#God" role="button" data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#God" role="button" data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

