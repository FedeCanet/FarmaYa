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

<script type="text/javascript">
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    alert("Latitude: " + position.coords.latitude +" Longitude: " + position.coords.longitude);
}
</script>
<body onload="getLocation()">
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
<%@include file="Includes/header.jsp" %>	
	
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
								<span class="input-group-addon">Tu Ciudad:</span>
								<select name="ciudad" class="form-control" noresults="No hay resultados con" id="ciudad">
									<option value="590">Artigas</option>
									<option value="665">Bella Unión</option>
									<option value="610">Canelones</option>
									<option value="11">Ciudad de la Costa</option>
									<option value="592">Colonia del Sacramento</option>
									<option value="717">Costa de Oro</option>
									<option value="608">Florida</option>
									<option value="375">Fray Bentos</option>
									<option value="439">Las Piedras</option>
									<option value="43">Maldonado</option>
									<option value="632">Melo</option>
									<option value="666">Mercedes</option>
									<option value="1" selected="selected">Montevideo</option>
									<option value="654">Pando</option>
									<option value="718">Parque del Plata</option>
									<option value="64">Paysandú</option>
									<option value="129">Piriápolis</option>
									<option value="10">Punta del Este</option>
									<option value="425">Rivera</option>
									<option value="101">Salto</option>
									<option value="453">San Carlos</option>
									<option value="136">San José</option>
									<option value="594">Tacuarembó</option>
									<option value="664">Treinta y Tres</option>
								</select>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Tu dirección:</span>
								<input type="text" name="direccion" class="form-control">
							</div>
							<div class="input-group">
								<span class="input-group-addon">Tu Producto o Farmacia:</span>
								<input type="text" name="producto" class="form-control">
							</div>
							</br></br>
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
	
<%@include file="Includes/footer.jsp" %>	

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>