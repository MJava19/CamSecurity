
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
            <input type="hidden" value="${group.id}" class="form-control" id="id" name="id">
            <h1>Category: ${groupName}</h1>
            <a href="/goods/create" class="btn btn-primary"><i class="far fa-eye">Add goods</i></a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description
                        <name></name>
                    </th>
                    <th scope="col">Price</th>
                    <th scope="col">Image</th>
                    <th scope="col">Add to basket or Buy</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${goods}" var="goods">
                    <tr>
                        <c:set var = "goods_id" value = "${goods.id}"/>
                        <th scope="row">${goods.code}</th>
                        <td>${goods.name}</td>
                        <td>${goods.description}</td>
                        <td>${goods.price}</td>
                        <td>
                            <c:forEach items="${goods.image}" var="goods">
                                <img width="150px" height="150px" src="data:image/png;base64,<c:out value='${goods.base64image}'/>"/>
                            </c:forEach>
                        </td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="/basket?id=${goods_id}" type="button"
                                   class="btn btn-primary"><i>Add to basket</i></a>
                                <a href="" type="button" class="btn btn-danger"><i>Buy</i></a>
                            </div>
                        </td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="/goods/one?id=${goods_id}" type="button"
                                   class="btn btn-primary"><i>edit</i></a>
                                <a href="/groups/list/goods/delete?id=${goods_id}" type="button" class="btn btn-danger"><i>delete</i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

