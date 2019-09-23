<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
 <style>
.w3-button {width:100px;}
</style>
<title>Register Form</title>
</head>
<body>

<p>Registrate Forastero<p>

	<div class = "w3-container">
	
		<h1>Register Form</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/register" method="POST">
				
					<div class = "form-group">
						<input type="text" class="form-control" name="email" placeholder="Enter email" value="${user.email}" required/>
					</div>
				
					<div class = "form-group">
						<input type="text" class="form-control" name="login" placeholder="Enter user name" value="${user.login}" required/>
					</div>
				
					<div class="form-group">
					  	<input type="password" class="form-control" name="password" placeholder="Enter password" value="${user.password}" required/>
					</div>
					
					<br>
					
					<button type="submit" class="w3-button w3-deep-purple">Send</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>