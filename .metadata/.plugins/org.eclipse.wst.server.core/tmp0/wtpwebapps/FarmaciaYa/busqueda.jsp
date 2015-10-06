<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Farmacia Ya</title>
	<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("inicio.jsp");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
	<header>
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-isf3">
						<span class="sr-only">Desplegar / Ocultar Menu</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">FarmaciaYa.com</a>
				</div>

				<!-- MENU Prueba -->
				<div class="collapse navbar-collapse" id="navegacion-isf3">
					<ul class="nav navbar-nav">
						<!-- <li class="active"><a href="inicio.jsp">Inicio</a></li> -->
						<li><a href="#">Mis Calificaciones</a></li>
					</ul>

					<form action="LogoutServlet" method="post" class="navbar-form navbar-right" role="loggin">
						<div class="row">						
							<div class="form-group">
							<span class="glyphicon glyphicon-user"></span>
								<a><%=user %></a>
							</div>						
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-off"></span>
								Cerrar Sessión
							</button>
						</div>
					</form>
				</div>
			</div>
		</nav>
	</header>
	
	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-13">
					<div class="text-center">
						<br>
				<div class="col-xs-13 hidden-xs hidden-sm">
					<h1 class="titulo-inicio">Buscá el producto online</h1>
					<p>Más de 250 Farmacias disponibles las 24hs los 7 días a la semana. <span class="glyphicon glyphicon-thumbs-up"></span></p>
				</div>
					<form action="" class="navbar-form" method="post">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Ciudad:</span>
								<input type="text" name="ciudad" class="form-control">
							</div>
							<div class="input-group">
								<span class="input-group-addon">Producto:</span>
								<input type="text" name="producto" class="form-control">
							</div>
							<button type="submit" name="Submit" class="btn btn-success">
							<span class="glyphicon glyphicon-search"></span> 
							Buscar
							</button>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<p>Ingeniería de Software III</p>
				</div>
				<div class="col-xs-6">
					<ul class="list-inline text-right">
						<li><a href="#">Inicio</a></li>
						<li><a href="#">Mis Calificaciones</a></li>
						<li><a href="#">Contacto</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>