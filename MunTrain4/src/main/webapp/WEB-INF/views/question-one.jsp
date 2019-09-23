<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific Question Detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "pt-5 container">
		
		<h1>Question Detail</h1>
		<hr/>
		
		
		<p>
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/questions/empty">Create New Question</a>
			
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Description</th>
				<th>ExamTemplate</th>
				<th>Responses</th>
				<th>Actions</th>
			</tr>
			
				<tr>
					<td>${question.description}</td>
					<td>${question.examtemplate}</td>
					
					<!-- Aquí estamos cogiendo el objeto question asociado por la relación bidireccional a response.
					Al ser un Array podemos sacar sus elementos y crear un enlace con ellos -->
					<td>
						<c:forEach items="${question.response}" var="response">
						<a class="enlace" href = "${pageContext.request.contextPath}/responses/${response.id}">${response.id}</a>
						</c:forEach>
					</td>
					<td> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/questions/${question.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/questions/${question.id}/delete">Delete</a> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/responses/empty">Add Response</a> 
					</td>
				</tr>
			
		</table>
		<br>
		<br>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/examtemplates">Back to the Exam Templates List</a>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>