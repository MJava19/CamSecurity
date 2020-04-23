<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} <img width="70px" height="70px" src="data:image/png;base64,<c:out value='${message.base64}'/>"/>|
            <a type="button"
               class="btn btn-primary" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>


        <h3>
            <a type="button"
               class="btn btn-primary"  href="/user/edit" >Edit your information</a>
        </h3>
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>



