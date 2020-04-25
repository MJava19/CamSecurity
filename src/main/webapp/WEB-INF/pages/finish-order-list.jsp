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
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>
<br>

<div class="container">
    <div class="row">
        <div class="col-12">
            <label>Total Price: ${totalPrice}</label>
            <br>
            <label>Total Goods: ${totalGoods}</label>
            <br>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">userName</th>
                    <th scope="col">Goods</th>
                    <th scope="col">totalGoods</th>
                    <th scope="col">totalPrice</th>
                    <th scope="col">firstName</th>
                    <th scope="col">lastName</th>
                    <th scope="col">fatherName</th>
                    <th scope="col">email</th>
                    <th scope="col">phoneNumber</th>
                    <th scope="col">region</th>
                    <th scope="col">city</th>
                    <th scope="col">numberBranch</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <c:set var = "order_id" value = "${order.id}"/>
                        <th scope="row">${order.userName}</th>
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