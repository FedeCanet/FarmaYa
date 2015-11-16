<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mis Calificaciones</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/estilos.css">
	<title>Insert title here</title>
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
	<%@include file="Includes/header.jsp" %>
	
	<br>
	<!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-md-1">
                <a href="#">
                    <img class="img-responsive" src="images/perfil.png" alt="Imagen de la Farmacia">
                </a>
            </div>
            <div class="col-md-5">
                <h3><% out.println(session.getAttribute("nombreCompleto")); %> </h3>
                <span class="restaurantInfo">                       
                    <span class="glyphicon glyphicon-map-marker"></span>
                    <span class="address"><small><% out.println(session.getAttribute("puntuacionDireccion")); %></small></span>
                </span>
                <span class="infoFooter">
                    <div class="minDelivery" title="El mínimo para pedir en este restaurante es $150">
                        <% out.println(session.getAttribute("user")); %>
                    </div>
                </span>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8">
                <h1 class="page-header">
                    Mis Pedidos
                    <small><p> (<% out.println(session.getAttribute("cantPedidos")); %> Pedidos)</p></small>
                </h1>
                
                
                <%=request.getAttribute("resultadoPuntuacion")%>
                
                <!--  
                <div class="well">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href="#">
                                <img class="img-responsive" src="images/imagefotofarmacia.jpg" alt="Imagen de la Farmacia">
                            </a>
                        </div>
                        <div class="col-lg-10">
                            <form action="PuntuarServlet" method="post" class="form-horizontal">
                                <div class="form-group">
                                    <p>#nombreFarmacia#</p>
                                    <p>Pedido:  #elPedido# </p>
                                    <p>Fecha: #fechaPedido#</p>
                                    <div class="col-md-10 columns">
                                    	<input type="hidden" name="idOrdenAPuntuar" value="#idOrdenAPuntuar#"/>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_MMala" value="1">
                                                Muy mala
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Mala" value="2">
                                                Mala
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Buena" value="3" checked>
                                                Buena
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_MBuena" value="4">
                                                Muy Buena
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Excelente" value="5">
                                                Excelente
                                        </label>
                                    </div>
                                </div>
                                <button class="btn btn-primary">CALIFICAR </button>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="well">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href="#">
                                <img class="img-responsive" src="images/imagefotofarmacia.jpg" alt="Imagen de la Farmacia">
                            </a>
                        </div>
                        <div class="col-lg-10">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <p>#nombreFarmacia#</p>
                                    <p>Pedido:  #elPedido# </p>
                                    <p>Fecha: #fechaPedido# </p>
                                    <div class="col-md-10 columns">
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_MMala" value="1" checked disabled>
                                                Muy mala
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Mala" value="2" disabled>
                                                Mala
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Buena" value="3" disabled>
                                                Buena
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_MBuena" value="4" disabled>
                                                Muy Buena
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="Radios" id="Radios_Excelente" value="5" disabled>
                                                Excelente
                                        </label>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                -->

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">
            </div>

        </div>
        <!-- /.row -->

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

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
</body>
</html>