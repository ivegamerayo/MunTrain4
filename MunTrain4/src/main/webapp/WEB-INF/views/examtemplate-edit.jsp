<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Examtemplate Edition</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "pt-5 container">
			<h2>Examtemplate ${examtemplate.id}</h2>
			<hr>
		<div class = " row justify-content-center">

			<div class = "col-md-8">
				 <form:form action = "${pageContext.request.contextPath}/examtemplates" method="POST" modelAttribute="examtemplate">
				
					<div class = "form-group">
					  <label for="descriptionET">Description</label>
					  <form:input path="descriptionET" class = "form-control" required="required"/>
					</div>
					
					<div class="form-group">
						<label for="publisher">publisher</label>
						<form:select path="publisher" class = "form-control" required="required">
							<form:option value="FALSE">false</form:option>
							<form:option value="TRUE">true</form:option>
						</form:select>
					</div>
										
					<form:hidden path="id"/>			
					
					<a class = "btn btn-info" href = "${pageContext.request.contextPath}/examtemplates" >Back to Exam Templates List</a>
					<button class = "btn btn-primary" type = "submit" >Save</button>
				</form:form>
        
			</div>
		</div>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>