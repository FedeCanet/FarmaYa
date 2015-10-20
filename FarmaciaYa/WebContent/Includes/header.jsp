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
						<li class="active"><a href="inicio.jsp">Inicio</a></li>
						<li><a href="#">Mis Calificaciones</a></li>
					</ul>
<%

if (session == null)
{
%>
					<form action="LoginServlet" method="post" class="navbar-form navbar-right" role="loggin">
						<div class="row">						
							<div class="form-group">
								<input type="text" name="user" class="form-control" placeholder="Correo">
								<input type="password" name="pwd" class="form-control" placeholder="Contraseña">								
							</div>						
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-ok"></span>
								Iniciar Sessión
							</button>
						</div>
						<div class="row">
								<font color=red><%
							    if(null!=request.getAttribute("errorMessage"))
							    {
							        out.println(request.getAttribute("errorMessage"));
							    }
							%></font>
							<ul class="text-center">
								<li><a href="recuperar.jsp">Olvidó su contraseña?</a></li>
							</ul>
						</div>
					</form>


<%
} else {
%>
<span class="navbar-brand active" style="float:right; padding-left:20px">
<a href="logout.jsp" >Salir</a>
</span>
<span class="navbar-brand" style="float:right">
Bienvenido <% out.println(session.getAttribute("user")); %>
</span>

<%
} 
%>

				</div>
			</div>
		</nav>
	</header>