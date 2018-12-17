<%@page import="com.rknowsys.estrolo.entities.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estrolo Application</title>
</head>
<jsp:include page="header.jsp"/>
<body>
	<div class="container">
		<h2 style="margin-left:70px">Category List</h2>


		
		<table border="2"  style="margin-left: 120px">

			<tr>
				
				<th scope="row">CategoryName</th>
				<th scope="row">Description</th>
				<th scope="row">IsParent</th>
				<th scope="row">Image</th>
				<th scope="row">Gender</th>
				<th scope="row">Status</th>
				<th scope="row">CreatedAt</th>
				<th scope="row">UpdatedAt</th>

			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					
					<td>${category.categoryName}</td>
					<td>${category.description}</td>
					<td>${category.isParent}</td>
					<td>${category.image}</td>
					<td>${category.gender}</td>
					<td>${category.status}</td>
					<td>${category.createdAt}</td>
					<td>${category.updatedAt}</td>
					<td>
					<a href="${pageContext.request.contextPath }/categories/deleteCategory/${category.categoryId}" onclick="return confirm('Are you sure?')">Delete</a>
				</td>
					<td><spring:url
							value="/categories/updateCategory/${category.categoryId}"
							var="updateURL" /> <a class="btn btn-primary"
						href="${updateURL }" role="button">Update</a></td>
				</tr>
			</c:forEach>
			</table>
			<spring:url value="/categories/addCategory" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Add New Category</a>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>