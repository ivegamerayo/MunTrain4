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
<script src="https://kit.fontawesome.com/dc38649408.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<div class = " container">
		
		<h1>Crea tu examen</h1>
		<hr/>
		
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/examtemplates/empty'">Create</button>
			
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
						
						<a href = "${pageContext.request.contextPath}/examtemplates/${examtemplate.id}"><i class="fas fa-edit"></i> </a>
						<a href = "${pageContext.request.contextPath}/examtemplates/${examtemplate.id}/delete"><i class="fas fa-trash-alt" style="color: red;"></i></a>
						<a href = "${pageContext.request.contextPath}/questions/empty" ><i class="fas fa-comment-medical" style="color: green;"></i></a>
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