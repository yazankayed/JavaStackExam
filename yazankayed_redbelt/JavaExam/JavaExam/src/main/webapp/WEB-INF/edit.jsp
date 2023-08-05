<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/21/2023
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Celebrity Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Edit Celebrity Page</h1>
<a href="/home">home</a>
<form:form action="/celebrities/${celebrity.id}" method="post" modelAttribute="celebrity">
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

<c:if test="${celebrity.pageManager.id == userId}">
    <h3>
        <a href="/delete/${celebrity.id}">Delete</a>
    </h3>

</c:if>

</body>
</html>
