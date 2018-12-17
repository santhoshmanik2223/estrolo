<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estrolo Application</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.myLogo {

	float: left;
	size: 16px 30px;
}

.topnav {
	overflow: hidden;
	background-color: #333;
	min-height:32px
}

.topnav a {
	float: right;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
	
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<div class="topnav" >
		<a class="navbar-brand myLogo" href="#" style="float: left;margin-bottom: 10px; "><img
			src="http://localhost:9090/images/Shirts/3.png" /></a>
		<a href="#" style="margin-top: 20px;">About</a> 
		<a href="#news" style="margin-top: 20px;">Contact Us</a>

		<spring:url value="/categories/addCategory" var="addURL" />
		<a href="${addURL }" style="margin-top: 20px;">Add New Category</a> <a class="active"
			href="${pageContext.request.contextPath}/categories/getallcategories" style="margin-top: 20px;">Home</a>
	</div>

	<h1 style="text-align: center;">Welcome to Estrolo Application</h1>

</body>
</html>