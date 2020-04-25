
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <a href="/groups/create" class="btn btn-primary"><i class="far fa-eye">Add group</i></a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Total Goods</th>
                    <th scope="col">Goods</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${group}" var="group">
                    <tr>
                        <th scope="row">${group.id}</th>
                        <td>${group.name}</td>
                        <td>${group.description}</td>
                        <td>${group.totalGoods}</td>
                        <td><a href="/groups/list/goods?id=${group.id}" type="button"
                               class="btn btn-primary"><i>Go to goods</i></a>
                        </td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="/groups/one?id=${group.id}" type="button"
                                   class="btn btn-primary"><i>edit</i></a>
                                <a href="/groups/delete?id=${group.id}" type="button" class="btn btn-danger"><i>delete</i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>