<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/md5.js"></script>
<script>
    var hash = CryptoJS.MD5("Message");
</script>

<script type="text/javascript">

psswd = Document.GetElementById("contrasena")

</script>
	<meta charset="UTF-8">
	<title>Farmacia Ya</title>
	<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<%@include file="Includes/headerNoLogin.jsp" %>
	
	<section class="jumbotron jumbotron-inicio">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<h3 >Ingrese nueva contraseña</h3>
				</div>

				<div class="col-xs-12 col-sm-6">
				<% int javavar = 8;
					String UserID = request.getParameter("userid");
				%>
					<div class="text-center">
						<br>
					<form action="ActualizarContrasena" method="post">
						<input name="userId" id="userId" type="text" value="<% out.println(request.getParameter("userid")); %>" style="display:none;">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Contrasena:</span>
								<input type="password" name="contrasena" id="contrasena" type="text" class="form-control" data-error="Complete este campo" required>
							</div>
						</div>	
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Repita Contrasena:</span>
								<input type="password" name="contrasenaRepetida" type="text"  class="form-control" data-error="Complete este campo" required>
								<% if(request.getAttribute("diferentesContrasenas")!=null){out.println(request.getAttribute("diferentesContrasenas"));} %>
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