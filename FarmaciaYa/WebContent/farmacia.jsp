<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilos.css">
<title>Farmacia</title>
</head>



<script>
function loadImage() {
	document.getElementById("buttonhid").click();
}
</script>

<%

if (request.getAttribute("comproProperty") == null)
{
%>

<body>

<%
} else {
%>

 <body onload="loadImage()">

<%
}
%>




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
<!--
	<header> <nav class="navbar navbar-inverse navbar-static-top"
		role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navegacion-isf3">
				<span class="sr-only">Desplegar / Ocultar Menu</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">FarmaciaYa.com</a>
		</div>

		<div class="collapse navbar-collapse" id="navegacion-isf3">
			<ul class="nav navbar-nav">
				<li><a href="#">Mis Calificaciones</a></li>
			</ul>

			<form action="LogoutServlet" method="post"
				class="navbar-form navbar-right" role="loggin">
				<div class="row">
					<div class="form-group">
						<span class="glyphicon glyphicon-user"></span>

					</div>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-off"></span> Cerrar Sessión
					</button>
				</div>
			</form>
		</div>
	</div>
	</nav> </header>
	-->
	
	<%@include file="Includes/header.jsp" %>

	<div class="container">

		<div class="row">
			<br>

			<div class="col-md-8">
				
				<%=request.getAttribute("farmaciaPresentacion")%>

				<%=request.getAttribute("farmaciaProductos")%>
				
			</div>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Blog Search Well -->
				<div class="well" style="display: none;">
					<h4>Buscar por nombre de Producto:</h4>
					<div class="input-group">
						<input type="text" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button" style="height:34px;">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
					<!-- /.input-group -->
				</div>

				<%=request.getAttribute("farmaciaCarrito")%> 			
				
			</div>
		</div>
		<!-- /.row -->
	</div>
		<hr>


			<button class="btn btn-primary btn-lg" style="visibility: hidden;" id="buttonhid" data-toggle="modal" data-target="#myModal">
			  Launch
			</button>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <!-- <button type="button" onclick="javascript:window.location.reload()" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        
			        <h4 class="modal-title" id="myModalLabel">Confirmación de compra</h4>
			        
			      </div>
			      <div class="modal-body">
			      	<img class="radius-fix" data-original="images/fast_delivery.jpg" src="images/fast_delivery.jpg" alt="delivery rapido" title="delivery rapido">
			       Gracias por su compra!!
			       Tiempo estimado de envío 40 minutos...
			      </div>
			      <div class="modal-footer">
			      		<button type="button" style="float:left; margin-left:190px;"class="btn btn-default" onclick="javascript:window.location.href = 'inicio.jsp';" data-dismiss="modal">Buscar otra Farmacia?</button>
			      </div>
			    </div>
			  </div>
			</div>


			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel"><img class="radius-fix" data-original="images/delivery.jpg" src="images/delivery.jpg" alt="Delivery" title="Delivery"> Medios de Pago</h4>
			      </div>
			      <div class="modal-body">
			      	<h5 class="modal-title" id="myModalLabel"><img class="radius-fix" data-original="images/cash.png" src="images/cash.png" alt="Efectivo" title="Efectivo"> Efectivo</h5>		
			       	<h5 class="modal-title" id="myModalLabel"><img class="radius-fix" data-original="images/ticket.png" src="images/ticket.png" alt="Ticket Alimentacion" title="Ticket Alimentacion"> Ticket Alimentacion</5>
			      </div>
			      <div class="modal-footer">
			      </div>
			    </div>
			  </div>
			</div>




		<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<p>Ingeniería de Software III</p>
				</div>
				<div class="col-xs-6">
					<ul class="list-inline text-right">
					</ul>
				</div>
			</div>
		</div>
		</footer>

		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>