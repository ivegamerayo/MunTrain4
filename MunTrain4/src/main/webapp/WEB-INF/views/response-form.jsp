<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Edition</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "pt-5 container">
			<h2>Response ${response.id}</h2>
			<hr>
		<div class = " row justify-content-center">

			<div class = "col-md-8">
				 <form:form action = "${pageContext.request.contextPath}/responses" method="POST" modelAttribute="response">
				
					<div class = "form-group">
					  <label for="descriptionR">DescriptionR</label>
					  <form:input path="descriptionR" class = "form-control" required="required"/>
					</div>
				
					<div class="form-group">
						<label for="image">Image</label>
						<br>
						<form:input path="image" name="image" placeholder="insert image url"
						class="form-control"/>
					</div>
					
					<div class="form-group">
					<label for="value">Value</label> <br>
						<form:select path="value" class = "form-control" required="required">
							<form:option value="false">false</form:option>
							<form:option value="true">true</form:option>
						</form:select>
					</div>
					
					<form:hidden path="id"/>
					
					<div class="form-group">
					<label for="question">Question</label> <br>
						<form:select class = "form-control" path="question"
						 items="${questions}" itemLabel="description" itemValue="id"/>
					</div>
	
					<a class = "btn btn-info" href = "${pageContext.request.contextPath}/questions/empty" >Back to Question Form</a>
					<a class = "btn btn-info" href = "${pageContext.request.contextPath}/examtemplates" >Back to Template List</a>
					<button class = "btn btn-primary" type = "submit" >Save</button>
				</form:form>
        
			</div>
		</div>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>