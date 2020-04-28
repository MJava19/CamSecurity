<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>

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

<div class="container">
    <div class="row">
        <div class="col-12"><br>
            <h1>Basket</h1>
            <br>
            <table class="table table-striped table-primary">
                <thead class="bg-primary">
                <tr>
                    <th scope="col">Зображення</th>
                    <th scope="col">Назва</th>
                    <th scope="col">Ціна</th>
                    <th scope="col">Видалити товар з кошика</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${basket.goods}" var="goods">
                    <tr>
                        <c:set var = "goods_id" value = "${goods.id}"/>
                        <td>
                                <div id="God${goods_id}" class="carousel slide mv" data-ride="carousel">

                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <c:forEach items="${goods.image}"  begin="0" end="0" var="goods_s">
                                                <img class="d-block" width="250px" height="250px" src="data:image/png;base64,<c:out value='${goods_s.base64image}'/>" alt="">
                                            </c:forEach>
                                        </div>
                                        <c:forEach items="${goods.image}" begin="1" var="goods_s">
                                            <div class="carousel-item">
                                                <img class="d-block" width="250px" height="250px" src="data:image/png;base64,<c:out value='${goods_s.base64image}'/>" alt="">
                                            </div>
                                        </c:forEach>
                                        <a class="carousel-control-prev" href="#God${goods_id}" role="button" data-slide="prev">
                                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#God${goods_id}" role="button" data-slide="next">
                                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </div>
                                </div>
                        </td>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                             <a href="/myBasket/delete?id=${goods_id}" type="button" class="btn btn-danger"><h4>Видалити</h4></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <h4><label>Кількість товарів в кошику: ${basket.totalGoods}</label></h4>
            <br>
            <h4><label>Загальна ціна: ${basket.totalPrice}</label></h4>
            <br>
            <a href="/order" type="button" class="btn btn-primary"><h3>Оформити доставку</h3></a>
        </div>
    </div>
</div>