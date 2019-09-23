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
.w3-button {width:150px;}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="w3-container">
	<p>
		<a class="w3-btn w3-red" onclick="window.location.href = '${pageContext.request.contextPath}/examtemplates'">Create New Exam</a>
	</p>
	
	<%-- <p>
		<a class="w3-btn w3-blue" onclick="window.location.href = '${pageContext.request.contextPath}/examtemplates'">See PreviousTemplates</a>
	</p> --%>
	
	<p>
		<a class="w3-btn w3-black" onclick="window.location.href ='${pageContext.request.contextPath}/exam'">Do An Exam</a>
	</p>
</div>

</body>
</html>