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
<br>
<br>

<h1>Followers</h1>

<c:forEach var="i" items="${followers}">
    <h3>  <c:out value="${i.userName}"/>  </h3>
    <h3>  <c:out value="${i.email}"/>  </h3>



</c:forEach>


<br>
<br>

<br>

<br>
<br>




<c:if test="${q==1 }">
    <h3>
you already followed the user    </h3>

</c:if>
<c:if test="${q==2 }">
    <h3>
        <a href="/celeb/join/${celebrityy.id}">Follow</a>
    </h3>

</c:if>



<c:if test="${celebrityy.pageManager.id == user_id}">
<h3>
    <a href="/celebrities/${celebrityy.id}/edit">edit</a>
</h3>

</c:if>





</body>
</html>
