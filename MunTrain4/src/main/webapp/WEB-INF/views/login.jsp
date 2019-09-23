<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page contentType="text/html; charset=UTF-8" %>
<!--
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





*** NO BORRAR ***




-->



<!DOCTYPE html>
<html lang="es">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <link rel="stylesheet" href="css/styleRegister.css">
  <title>Login or Register</title>
</head>

<body>
  <header class="v-header container">
    <div class="fullscreen-video-wrap">
      <video autoplay="true" loop="false" src="video/videoLogin.mp4"></video>
    </div>
    <div class="header-overlay"></div>
    <div class="header-content">

        <div id="login-forma">
            <h3 id="registro-title">Entra con tu cuenta</h3>
                        <div class="row">
                                <form action="${pageContext.request.contextPath}/login" method="POST" class="col s12">
                                 Nombre de Usuario:
                                  <div class="row">
                                    <div class="input-field col s12">
                                      <input id="disabled" type="text" class="validate" value="${user.login}" name="login" required> 
                                      <label for="disabled"></label>
                                    </div>
                                  </div>
                                  Contraseña:
                                  <div class="row">
                                    <div class="input-field col s12">
                                      <input id="password" type="password" name="password" class="validate" value="${user.password}" required>
                                      <label for="password"></label>
                                    </div>
                                  </div>
                                  <button class="btn waves-effect waves-light btn-submit" type="submit">ENTRAR
                                    <i class="material-icons right">arrow_forward</i>
                                  </button>
								  <p>¿No estas registrado? <a id="loginregister" class="redirectlogin" href="${pageContext.request.contextPath}/register">Regístrate</a></p>
								
                                  </div>
                                </form>
                              </div>   
    <div>

   

   
  </header>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</html>
