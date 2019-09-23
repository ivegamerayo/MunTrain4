<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Template List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "pt-5 container">
		
		<h1>Exam Template Directory</h1>
		<hr/>
		
		
		<p>
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/examtemplates/empty">Create New Exam</a>
			
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Description</th>
				<th>Publisher</th>
				<th>Questions</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${examtemplates}" var="examtemplate">
				<tr>
					<td>${examtemplate.descriptionET}</td>
					<td>${examtemplate.publisher}</td>
					<td>
					
						<c:forEach items="${examtemplate.question}" var="question">
						<a class="enlace" href = "${pageContext.request.contextPath}/questionstemplate/${question.id}">${question.id}</a>
						</c:forEach>
					</td>
					<td> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/examtemplates/${examtemplate.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/examtemplates/${examtemplate.id}/delete">Delete</a>
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/questions/empty">Add Questions</a>
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		<br>
		<br>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/menu">Back to the Menu</a>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>