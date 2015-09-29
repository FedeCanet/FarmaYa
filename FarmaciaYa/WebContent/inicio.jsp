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

				<!-- MENU -->
				<div class="collapse navbar-collapse" id="navegacion-isf3">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Inicio</a></li>
						<li><a href="#">Mis Calificaciones</a></li>
					</ul>

					<form action="" class="navbar-form navbar-right" role="loggin">
						<div class="row">						
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Correo">
								<input type="text" class="form-control" placeholder="Contrase�a">
							</div>						
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-ok"></span>
								Iniciar Sessi�n
							</button>
						</div>
						<div class="row">
							<ul class="text-center">
								<li><a href="#">Olvido su contrase�a?</a></li>
							</ul>
						</div>
					</form>
				</div>
			</div>
		</nav>
	</header>
	
	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 hidden-xs hidden-sm">
					<h1 class="titulo-inicio">Farmacia Ya</h1>
					<p>Bienvenido a FarmaciaYa el sitio por excelencia</p>
					<p>para pedir productos farmac�uticos.</p>
					<p>M�s de 250 Farmacias disponibles</p>
					<p>24/7</p>
					<p><a href="#" class="btn btn-primary btn-lg">Leer mas</a></p>
				</div>

				<div class="col-xs-6">
					<div class="text-center">
						<br>
					<form action="" method="post">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Nombre:</span>
								<input type="text" name="nombre" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Apellido:</span>
								<input type="text" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Direcci�n:</span>
								<input type="text" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Correo:</span>
								<input type="text" class="form-control">
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Contrase�a:</span>
								<input type="text" class="form-control">
							</div>
						</div>
												
						<button type="submit" name="Submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Confirmar</button>
					</FORM>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<p>Ingenier�a de Software III</p>
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