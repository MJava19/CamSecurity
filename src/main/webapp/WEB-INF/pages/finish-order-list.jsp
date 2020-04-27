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
        <div class="col-12">
            <h2><label>Сума заробітку з усіх товарів: ${totalPrice}</label></h2>
            <br>
            <h2><label>Кількість проданих товарів: ${totalGoods}</label></h2>
            <br>
            <table class="table table-hover table-primary">
                <thead class="bg-primary">
                <tr>
                    <th scope="col">Товари</th>
                    <th scope="col">Кількість товарів</th>
                    <th scope="col">Загальна ціна</th>
                    <th scope="col">Ім'я</th>
                    <th scope="col">Прізвище</th>
                    <th scope="col">По-Батькові</th>
                    <th scope="col">Email</th>
                    <th scope="col">Номер телефону</th>
                    <th scope="col">Область</th>
                    <th scope="col">Місто</th>
                    <th scope="col">Номер відділення</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <c:set var = "order_id" value = "${order.id}"/>
                        <td>
                            <c:forEach items="${order.goodsList}" var="goods">
                                <label>Code: ${goods.code}</label>
                                <label>Name: ${goods.name}</label>
                            </c:forEach>
                        </td>
                        <td>${order.totalGoods}</td>
                        <td>${order.totalPrice}</td>
                        <td>${order.firstName}</td>
                        <td>${order.lastName}</td>
                        <td>${order.fatherName}</td>
                        <td>${order.email}</td>
                        <td>${order.phoneNumber}</td>
                        <td>${order.region}</td>
                        <td>${order.city}</td>
                        <td>${order.numberBranch}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>