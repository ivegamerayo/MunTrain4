<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!--
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

-->


<!DOCTYPE html>
<html lang="es">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <link rel="stylesheet" href="css/styleRegister.css">
  <title>Register in Muntrain</title>
</head>

<body>
  <header class="v-header container">
    <div class="fullscreen-video-wrap">
      <video autoplay="true" loop="false" src="video/videoLogin.mp4"></video>
    </div>
    <div class="header-overlay"></div>
    <div class="header-content">

      <!--FORM REGISTRO:-->
      <div id="registro-forma">
          <h3 id="registro-title">Comienza a Entrenar</h3>
          <div class="row">
            <form class="col s12" action = "${pageContext.request.contextPath}/register" method="POST">
              Nombre de Usuario:
              <div class="row">
                <div class="input-field col s12">
                  <input id="disabled" type="text" class="validate" value="${user.login}" required name="login" />
                  <label for="disabled"></label>
                </div>
              </div>
              Contraseña:
              <div class="row">
                <div class="input-field col s12">
                  <input id="password" type="password" class="validate" name="password" value="${user.password}" required>
                  <label for="password"></label>
                </div>
              </div>
              Email:
              <div class="row">
                <div class="input-field col s12">
                  <input id="email" type="email" class="validate" value="${user.email}" required name="email">
                  <label for="email"></label>
                </div>
              </div>
              <button class="btn waves-effect waves-light btn-submit" type="submit" name="action">REGISTRARSE
                <i class="material-icons right">arrow_forward</i>
              </button>
              <p>¿Ya estas registrado? <a class="redirectlogin" id="loginclick" href="login.html">Entra aquí</a></p>
          </div>
          </form>
        </div>
      </div>
    <div>

   

   
  </header>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="changeform.js"></script>
</html>