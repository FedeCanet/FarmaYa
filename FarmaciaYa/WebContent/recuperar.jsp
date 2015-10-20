<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
	<meta charset="UTF-8">
	<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	<title>Farmacia Ya</title>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<%@include file="Includes/header.jsp" %>	

	
	
<%	
if(null==request.getParameter("correo"))
{  
%>

	
	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 hidden-xs hidden-sm">
					<h3 >Recuperar Contraseña</h3>
					<p>Ingrese la dirección su dirección de correo, recibirá un mail con los pasos a seguir</p>
					
				</div>

				<div class="col-xs-6">
					<div class="text-center">
						<br>
					<form action="RecoverPasswordServlet" method="post" data-toggle="validator">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Correo:</span>
								<input type="email" id="correo" name="correo" class="form-control"  data-error="Ingresa un mail válido" required>
							</div>
						</div>
										
						<button type="submit" name="Submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Confirmar</button>
					</form>
					</div>
				</div>
			</div>
		</div>
	</section>
<%
}
else
{
%>

	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-13">
					<h3 ><% out.println(request.getAttribute("title")); %></h3>
					<p><% out.println(request.getAttribute("text")); %></p>
					
				</div>
			</div>
		</div>
	</section>

<%	
}
%>	

<%@include file="Includes/footer.jsp" %>	


</body>
</html>