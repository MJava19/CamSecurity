
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>

<div class="container">
    <div class="row">
        <div class="col-12"><br>
            <h1>Basket</h1>
            <br>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Image</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${basket.goods}" var="goods">
                    <tr>
                        <c:set var = "goods_id" value = "${goods.id}"/>
                        <td>
                            <c:forEach items="${goods.image}" var="goods_image">
                                <img width="150px" height="150px" src="data:image/png;base64,<c:out value='${goods_image.base64image}'/>"/>
                            </c:forEach>
                        </td>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="/myBasket/delete?id=${goods_id}" type="button" class="btn"><i>delete</i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <label for="totalGoods">Total goods in basket: ${basket.totalGoods}</label>
            <br>
            <label for="totalPrice">Total price: ${basket.totalPrice}</label>
            <br>
            <a href="/order" type="button" class="btn"><i>Buy</i></a>
        </div>
    </div>
</div>