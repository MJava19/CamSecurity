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
            <form action="/groups/update" method="POST">
                <input type="hidden" value="${group.id}" class="form-control" id="id" name="id">
                <div class="form-group">
                    <label>Group name:</label> <input type="text"
                                                      class="form-control" id="name" name="name"
                                                      value="${group.name}">
                    <br>
                    <label>Group description:</label> <input type="text"
                                                             class="form-control" id="description" name="description"
                                                             value="${group.description}">
                </div>


                <button type="submit" class="btn btn-default">Update</button>
                <a href="/groups" type="submit" class="btn btn-info">Back to groups</a>
            </form>
        </div>
    </div>
</div>