<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Goods</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" border-radius="0px">
   <h2> <a class="nav-link mr-auto" href="/goods">
       CamSecurity
    </a></h2>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
               <h3> <a class="nav-link"  font-size="1rem" href="/goods">Товари</a></h3>
            </li>
            <li class="nav-item">
                <h3><a class="nav-link" href="/groups">Категорії</a></h3>
            </li>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
            <li class="nav-item">
                <h3><a class="nav-link" href="/">Особистий кабінет</a></h3>
            </li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item">
                <div class="btn-group">
                <button type="button" class="btn btn-primary" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <h4>Інструменти Адміна</h4>
                </button>
                <div class="dropdown-menu">
                    <h4><a class="dropdown-item" href="/goods/create">Додати товар</a></h4>
                    <h4><a class="dropdown-item" href="/groups/create">Додати групу</a></h4>
                    <h4><a class="dropdown-item" href="/order/finish">Виконані замовлення</a></h4>
                    <div class="dropdown-divider"></div>
                    <h4><a class="dropdown-item" href="/admin/orders">Нові замовлення</a></h4>
                </div>
                </div>
            </li>
</sec:authorize>

            <form class="form-inline my-2 my-lg-0">
                <h3><a class="nav-link nav-item marg" href="/myBasket">Кошик</a></h3>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <a class="btn btn-outline-danger"  href="/logout"><h4>Вийти</h4></a>
</sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                 <a class="btn btn-outline-success marg" href="/login"><h4>Ввійти</h4></a>
                </sec:authorize>

            </form>
        </ul>
    </div>
</nav>
</body>
</html>


