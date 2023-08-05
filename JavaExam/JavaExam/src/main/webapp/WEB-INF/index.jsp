<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/21/2023
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Add Celebrity Page</title>
</head>
<body>
<h1>New Celebrity Page</h1>
<a href="/home">home</a>
<form:form action="/clebrities/new" method="post" modelAttribute="celebrity">
    <form:input type="hidden" path="pageManager" value="${user.id}"/>
    <p>
        <form:label path="name">Name</form:label>
    <p class="error" style="color: red;"><form:errors path="name"/></p>
    <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
    <p class="error" style="color: red;"><form:errors path="description"/></p>
    <form:input path="description"/>
    </p>


    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</body>
</body>
</html>

