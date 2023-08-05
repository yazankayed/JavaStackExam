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
  <title>Fan Pages</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<main class="container">
  <div>
  <h1>Welcome, <c:out value="${currentUser.userName}"/> !</h1>
  <h4><a href="/logout">logout</a></h4>
  </div>
  <a href="/clebrities/new">Add Celebrity Page</a>
  <br>
  <c:forEach var="i" items="${allcelb}">
      <h1> <a href="/celeb/${i.id}"> <c:out value="${i.name}"/>  </a></h1>
    <h2> Page Manager: <c:out value="${i.pageManager.userName}"/>  </h2>



  </c:forEach>
</main>
</body>
</html>