<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
<title>Insert title here</title>
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
							
						</div>						
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-off"></span>
							Cerrar Sessi�n
						</button>
					</div>
				</form>
			</div>
		</div>
	</nav>
</header>

<div class="container">

	<%=request.getAttribute("farmaciaPresentacion")%>
	<!-- 
	<div id="profileHeader" class="row full">    
		<section id="profileInfo" data-id="18298" class="">
			<div>
				<h1 itemprop="name" class="withLabel">Farmacia 8 de Octubre</h1>	        
	            <label class="open-time">Abre a las 19:30</label>
			</div>
	    
			<div>    
				<div style="display: none;" itemprop="aggregateRating" itemscope="" itemtype="http://schema.org/AggregateRating">
					<span itemprop="ratingValue">3.9</span> <span itemprop="ratingCount">1401</span>
				</div>
	            <span class="rating-points">Puntaje 3.9</span>
	            <span class="rating rating_40"></span>
			</div>

			<div id="profileDetails">
				<span class="deliveryTime" data-link="false" title="El tiempo estimado de entrega es de 45-60 mins" data-time="45-60 mins"><i></i>
						45-60 mins
					<small>
						tiempo de entrega
					</small>
				</span>

	            <span class="shippingAmount" data-link="true" title="Sin costo de env�o"><i></i>Gratis<small>costo de env�o</small></span>
				<span class="deliveryAmount" data-link="false" title="El m�nimo para pedir en este restaurante es $100">
				<i></i>$100 <small>pedido m�nimo</small></span>
				<button class="btn btn-success">Ver medios de pago</button>
			</div>
		</section>
	</div>
	 -->

	<br>
	<br>


	<div class="main">
		<div class="row container">
		
		<%=request.getAttribute("farmaciaProductos")%>
		<!-- 
			<section id="menu" data-click="true">

				<section class="menuSectionContainer">
					<ul class="highlight_list">
						<li class="peyaCard product most" data-id="1610399" data-options="2" data-autolink="promo-1-pizzeta-muzzarella-con-dos-gustos-pepsi-de-1-5-l-o-cerveza-pilsen">        
							<h4>
								<i class="mostOrdered"></i>
								Aspirina 
							</h4>
							<div class="price">
								<span>$395</span>
							</div>
							
							<button class="btn btn-primary">Agregar al Carrito</button>
							
							<p></p>
						</li>


				    </ul>

				    <ul CLASS="highlight_list">
						<li class="peyaCard product " data-id="1610402" data-options="1" data-autolink="promo-4-chivito-al-plato-para-dos-pepsi-de-1-5-l-o-cerveza-pilsen-de-1-l" style="height: 104px;">
							<h4>
								Zolven
							</h4>
			                <div class="price">
			                    <span>$750</span>
			                </div>
			            
							<button class="btn btn-primary">Agregar al Carrito</button>
							<p></p>
						</li>
				    </ul>
				</section>
			</section>
 -->
 
 <%=request.getAttribute("farmaciaCarrito")%>
 <!--
			<aside id="cartContainer" class="large-4 medium-4 small-4 columns" style="float:right">
	<div id="cartContentWrap" class="">
		<div id="content">
			<div class="peyaCard" id="cart" data-valid="true">
				<header>
					<h4>Mi pedido</h4>
				</header>
				<div id="scrollContainer">
					<span id="scrollContent">
						<ul>
							<li data-json="{&quot;product&quot;:1610399,&quot;name&quot;:&quot;Promo 1 - Pizzeta muzzarella con dos gustos + Pepsi de 1.5 L o Cerveza Pilsen&quot;,&quot;quantity&quot;:1,&quot;notes&quot;:&quot;&quot;,&quot;optionGroups&quot;:[{&quot;productOptionGroup&quot;:955435,&quot;name&quot;:&quot;Gustos&quot;,&quot;options&quot;:[{&quot;productOption&quot;:5536392,&quot;name&quot;:&quot;Anan�&quot;,&quot;productOptionQty&quot;:2,&quot;type&quot;:&quot;select&quot;}]},{&quot;productOptionGroup&quot;:954617,&quot;name&quot;:&quot;Opci�n&quot;,&quot;options&quot;:[{&quot;productOption&quot;:5531524,&quot;name&quot;:&quot;Cerveza Pilsen de 1 L&quot;,&quot;productOptionQty&quot;:1,&quot;type&quot;:&quot;radio&quot;}]}],&quot;restaurant&quot;:31514}" id="1610399" title="Editar" class="">
								<div class="productQuantity dropdown" title="Seleccionar cantidad">
									<select name="qty_1610399" class="" id="qty_1610399">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</div>
								<div class="name">Aspirina</div>
								<div class="price">$395</div>
								<div class="remove"><button type="button" class="button none" title="Quitar">Quitar</button></div>
							</li>
						
							<li data-json="{&quot;product&quot;:1665461,&quot;name&quot;:&quot;Promo - Muzzarrella 3 x 2&quot;,&quot;quantity&quot;:1,&quot;restaurant&quot;:31514,&quot;optionGroups&quot;:[]}" id="1665461" title="Editar" class="modified seen">
								<div class="productQuantity dropdown" title="Seleccionar cantidad">
									<select name="qty_1665461" class="" id="qty_1665461">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</div>
								<div class="name">Zolven</div>
								<div class="price">$270</div>
								<div class="remove"><button type="button" class="button none" title="Quitar">Quitar</button></div>
							</li>
						</ul>

						<section id="subtotal" class="prefooterinfo ">
							<div class="description">Subtotal</div>
							<div class="price">$665</div>
						</section>

						<section id="deliveryType" class="prefooterinfo" data-value="0">
								<div class="data">
									<span title="8 de Octubre 2486">                
												Delivery para 8 de Octubre 2486
									</span>
								</div>
						</section>

						<section id="totalPrice" class="prefooterinfo">
							<div class="description">Total</div>
							<div class="price">$665</div>
						</section>
					</span>
				</div>

					<footer>    
						<button class="btn btn-success">Realizar Pedido</button>
					</footer>

					<div id="cartOverlay" style="display: none;">
							<svg class="spinner" width="65px" height="65px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg">
								<circle class="circle" fill="none" stroke-width="2.5" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
							</svg>
					</div>
			</div>    
		</div>
	</div>
</aside>
-->
		</div>
	</div>




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