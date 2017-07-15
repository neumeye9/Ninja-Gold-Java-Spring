<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
	<form action="/reset" method="POST">
		<input type="submit" value="Reset"></input>
	</form>
	<h1>Your gold = <c:out value="${gold}"/></h1>
	<br>
	<br>
	<h3>Farm</h3>
	<p>(earns 10-20 gold)</p>
	<form action="/farm" method="POST">
		<input type="submit" value="Find Gold!"></input>
	</form>
	<br>
	<br>
	<h3>Cave</h3>
	<p>(earns 5-10 gold)</p>
	<form action="cave" method="POST">
		<input type="submit" value="Find Gold!"></input>
	</form>
	<br>
	<br>
	<h3>House</h3>
	<p>(earns 2-5 gold)</p>
	<form action="house" method="POST">
		<input type="submit" value="Find Gold!"></input>
	</form>
	<br>
	<br>
	<h3>Casino!</h3>
	<p>(earns/takes 0-50 gold)</p>
	<form action="casino" method="POST">
		<input type="submit" value="Find Gold!"></input>
	</form>
	<br>
	<br>
	<h3>Activities</h3>
		<c:forEach var="item" items="${myArray}">
			<c:out value="${item}"/>
		</c:forEach>

</body>
</html>