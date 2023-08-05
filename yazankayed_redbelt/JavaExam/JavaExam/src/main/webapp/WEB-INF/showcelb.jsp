<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>View Celebrity</title>
</head>
<body>
<h1>  ${celebrityy.name}  </h1>
<a href="/home">home</a>

    <h2> Page Manager: ${celebrityy.pageManager.userName}  </h2>
<h2> Contact: ${celebrityy.pageManager.email}  </h2>
<h2>Details:</h2>
<h1> ${celebrityy.description}  </h1>

<c:if test="${celebrityy.pageManager.id == user_id}">
<h3>
    <a href="/celebrities/${celebrityy.id}/edit">edit</a>
</h3>

</c:if>





</body>
</html>
