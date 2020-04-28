<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
<c:forEach items="${goods}" var="good">
    <c:set var="goods_id" value="${good.id}"/>
    <div class="cards bg">
        <div class="row ">
            <div class="col-md-7 px-3">
                <div class="card-block px-6">
                    <h4 class="card-title">${good.name}</h4>
                    <p class="card-text"><h5>${good.description}</h5></p>
                    <br>
                    <h4 class="card-title">Виробник товару: ${good.manufacturer}</h4>
                    <br>
                    <h4 class="card-title">Код товару: ${good.code}</h4>
                    <a href="/basket?id=${goods_id}" class="mt-auto btn btn-primary"><h4>Додати в кошик</h4></a>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="/goods/one?id=${goods_id}" class="mt-auto btn btn-danger"><h4>Редагувати</h4></a>
                        <a href="/goods/delete?id=${goods_id}" class="mt-auto btn btn-danger"><h4>Видалити</h4></a>
                    </sec:authorize>
                </div>
            </div>
            <div class="col-md-5">

                <div id="God${good.id}" class="carousel slide" data-ride="carousel">

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <c:forEach items="${good.image}" begin="0" end="0" var="goods_s">
                                <img class="d-block" width="300px" height="300px"
                                     src="data:image/png;base64,<c:out value='${goods_s.base64image}'/>" alt="">
                            </c:forEach>
                        </div>
                        <c:forEach items="${good.image}" begin="1" var="goods_n">
                            <div class="carousel-item">
                                <img class="d-block" width="300px" height="300px"
                                     src="data:image/png;base64,<c:out value='${goods_n.base64image}'/>" alt="">
                            </div>
                        </c:forEach>
                        <a class="carousel-control-prev" href="#God${good.id}" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#God${good.id}" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
