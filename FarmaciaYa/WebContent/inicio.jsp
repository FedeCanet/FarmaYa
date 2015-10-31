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
if(session.getAttribute("user") != null){
	response.sendRedirect("busqueda.jsp");
}
%>

	<%@include file="Includes/header.jsp" %>	
	
	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 hidden-xs hidden-sm">
					<h1 class="titulo-inicio">Farmacia Ya</h1>
					<p>Bienvenido a FarmaciaYa el sitio por excelencia</p>
					<p>para pedir productos farmacéuticos.</p>
					<p>Más de 250 Farmacias disponibles</p>
					<p>24/7</p>
					<p><a href="#" class="btn btn-primary btn-lg">Leer mas</a></p>
				</div>
			
				<div class="col-xs-13">
					<div class="text-center">
						<br>
					<form action="UsuarioServlet" method="post" data-toggle="validator">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Nombre:</span>
								<input type="text" id="nombre" name="nombre" class="form-control"  data-error="Ingresa tu Nombre" required>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Apellido:</span>
								<input type="text" id="apellido" name="apellido" class="form-control" data-error="Ingresa tu apellido" required>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Dirección:</span>
								<input type="text" id="direccion" name="direccion" class="form-control" data-error="Ingresa tu dirección" required>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Correo:</span>
								<input type="email" id="correo" name="correo" class="form-control" data-error="Ingresa un mail válido" required>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Contraseña:</span>
								<input type="password" id="password" name="password" data-minlength="6" maxlength="8" class="form-control"  data-error="Ingresa una contraseña" required>
							</div>
						</div>
												
						<button type="submit" name="Submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Confirmar</button>
					</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
<%@include file="Includes/footer.jsp" %>	

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>