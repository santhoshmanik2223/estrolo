<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	String formattedDate = df.format(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estrolo Application</title>

</head>
<jsp:include page="header.jsp"/>
<body>
	<div class="container">
		<spring:url value="/categories/saveCategory" var="saveURL" />
		<h2>Add Category</h2>
		<form:form modelAttribute="categoryForm" method="post"
			action="${saveURL }" cssClass="form" enctype="multipart/form-data">
			<div class="form-group">
				<label>CategoryName</label>
				<form:input path="categoryName" cssClass="form-control"
					id="categoryName" />
			</div>
			<div class="form-group">
				<label style="padding-bottom: 20px;">Description</label>
				<form:textarea path="description" cssClass="form-control"
					id="description" />
			</div>
			<div class="form-group">
				<label>Gender</label>
				<form:select path="gender">
					<form:option value="SelectGender">Select Gender</form:option>
					<form:option value="Male">Male</form:option>
					<form:option value="Female">Female</form:option>
					<form:option value="Unisex">Unisex</form:option>
				</form:select>

			</div>

			<div class="form-group">
				<label>Status</label>
				<form:select path="status">
					<form:option value="0">Select Status</form:option>
					<form:option value="1">Show</form:option>
					<form:option value="0">Hide</form:option>
				</form:select>

			</div>

			<div class="form-group">
				<label>IsParent</label>

				<form:checkbox path="isParent" cssClass="form-control" id="isParent" />
			</div>


			<div class="form-group">

				<label for="photo">Image</label> <input type="file" name="image" 
					id="image" size="50"  /><br>
				<br>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>

	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>