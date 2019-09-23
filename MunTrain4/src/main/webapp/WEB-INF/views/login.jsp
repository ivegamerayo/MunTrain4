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
<title>Welcome to MuntrainApp</title>
</head>
<body>

	<div class = "w3-container">
	
		<h1>Login</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/login" method="POST">
				
				
					<div class = "form-group">
						<input type="text" class="form-control" name="login" placeholder="Enter user name" value="${user.login}" required/>
					</div>
				
					<div class="form-group">
					  	<input type="password" class="form-control" name="password" placeholder="Enter password" value="${user.password}" required/>
					</div>
				
					<%-- <input type="hidden" name="id" value="${user.id}"/> --%>
					<br>			
					<button type="submit" class = "w3-button w3-green">Send</button>
				</form>
			</div>
		</div>
		<a class = "btn btn-info" href = "${pageContext.request.contextPath}/register" >Register</a>
	</div>
	
</body>
</html>