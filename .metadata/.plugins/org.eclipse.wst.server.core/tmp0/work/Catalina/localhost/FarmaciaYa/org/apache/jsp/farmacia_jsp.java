/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.63
 * Generated at: 2015-10-13 22:37:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class farmacia_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/estilos.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("\t<nav class=\"navbar navbar-inverse navbar-static-top\" role=\"navigation\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navegacion-isf3\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Desplegar / Ocultar Menu</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"navbar-brand\">FarmaciaYa.com</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- MENU Prueba -->\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\" id=\"navegacion-isf3\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<!-- <li class=\"active\"><a href=\"inicio.jsp\">Inicio</a></li> -->\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Mis Calificaciones</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form action=\"LogoutServlet\" method=\"post\" class=\"navbar-form navbar-right\" role=\"loggin\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-user\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-off\"></span>\r\n");
      out.write("\t\t\t\t\t\t\tCerrar Sessión\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t");
      out.print(request.getAttribute("farmaciaPresentacion"));
      out.write("\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t<div id=\"profileHeader\" class=\"row full\">    \r\n");
      out.write("\t\t<section id=\"profileInfo\" data-id=\"18298\" class=\"\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h1 itemprop=\"name\" class=\"withLabel\">Farmacia 8 de Octubre</h1>\t        \r\n");
      out.write("\t            <label class=\"open-time\">Abre a las 19:30</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t\t<div>    \r\n");
      out.write("\t\t\t\t<div style=\"display: none;\" itemprop=\"aggregateRating\" itemscope=\"\" itemtype=\"http://schema.org/AggregateRating\">\r\n");
      out.write("\t\t\t\t\t<span itemprop=\"ratingValue\">3.9</span> <span itemprop=\"ratingCount\">1401</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t            <span class=\"rating-points\">Puntaje 3.9</span>\r\n");
      out.write("\t            <span class=\"rating rating_40\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"profileDetails\">\r\n");
      out.write("\t\t\t\t<span class=\"deliveryTime\" data-link=\"false\" title=\"El tiempo estimado de entrega es de 45-60 mins\" data-time=\"45-60 mins\"><i></i>\r\n");
      out.write("\t\t\t\t\t\t45-60 mins\r\n");
      out.write("\t\t\t\t\t<small>\r\n");
      out.write("\t\t\t\t\t\ttiempo de entrega\r\n");
      out.write("\t\t\t\t\t</small>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\r\n");
      out.write("\t            <span class=\"shippingAmount\" data-link=\"true\" title=\"Sin costo de envío\"><i></i>Gratis<small>costo de envío</small></span>\r\n");
      out.write("\t\t\t\t<span class=\"deliveryAmount\" data-link=\"false\" title=\"El mínimo para pedir en este restaurante es $100\">\r\n");
      out.write("\t\t\t\t<i></i>$100 <small>pedido mínimo</small></span>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\">Ver medios de pago</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t -->\r\n");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"row container\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.print(request.getAttribute("farmaciaProductos"));
      out.write("\r\n");
      out.write("\t\t<!-- \r\n");
      out.write("\t\t\t<section id=\"menu\" data-click=\"true\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<section class=\"menuSectionContainer\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"highlight_list\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"peyaCard product most\" data-id=\"1610399\" data-options=\"2\" data-autolink=\"promo-1-pizzeta-muzzarella-con-dos-gustos-pepsi-de-1-5-l-o-cerveza-pilsen\">        \r\n");
      out.write("\t\t\t\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"mostOrdered\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\tAspirina \r\n");
      out.write("\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"price\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>$395</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary\">Agregar al Carrito</button>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t    </ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t    <ul CLASS=\"highlight_list\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"peyaCard product \" data-id=\"1610402\" data-options=\"1\" data-autolink=\"promo-4-chivito-al-plato-para-dos-pepsi-de-1-5-l-o-cerveza-pilsen-de-1-l\" style=\"height: 104px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t\t\t\tZolven\r\n");
      out.write("\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t                <div class=\"price\">\r\n");
      out.write("\t\t\t                    <span>$750</span>\r\n");
      out.write("\t\t\t                </div>\r\n");
      out.write("\t\t\t            \r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary\">Agregar al Carrito</button>\r\n");
      out.write("\t\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write(" -->\r\n");
      out.write(" \r\n");
      out.write(" ");
      out.print(request.getAttribute("farmaciaCarrito"));
      out.write("\r\n");
      out.write(" <!--\r\n");
      out.write("\t\t\t<aside id=\"cartContainer\" class=\"large-4 medium-4 small-4 columns\" style=\"float:right\">\r\n");
      out.write("\t<div id=\"cartContentWrap\" class=\"\">\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<div class=\"peyaCard\" id=\"cart\" data-valid=\"true\">\r\n");
      out.write("\t\t\t\t<header>\r\n");
      out.write("\t\t\t\t\t<h4>Mi pedido</h4>\r\n");
      out.write("\t\t\t\t</header>\r\n");
      out.write("\t\t\t\t<div id=\"scrollContainer\">\r\n");
      out.write("\t\t\t\t\t<span id=\"scrollContent\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li data-json=\"{&quot;product&quot;:1610399,&quot;name&quot;:&quot;Promo 1 - Pizzeta muzzarella con dos gustos + Pepsi de 1.5 L o Cerveza Pilsen&quot;,&quot;quantity&quot;:1,&quot;notes&quot;:&quot;&quot;,&quot;optionGroups&quot;:[{&quot;productOptionGroup&quot;:955435,&quot;name&quot;:&quot;Gustos&quot;,&quot;options&quot;:[{&quot;productOption&quot;:5536392,&quot;name&quot;:&quot;Ananá&quot;,&quot;productOptionQty&quot;:2,&quot;type&quot;:&quot;select&quot;}]},{&quot;productOptionGroup&quot;:954617,&quot;name&quot;:&quot;Opción&quot;,&quot;options&quot;:[{&quot;productOption&quot;:5531524,&quot;name&quot;:&quot;Cerveza Pilsen de 1 L&quot;,&quot;productOptionQty&quot;:1,&quot;type&quot;:&quot;radio&quot;}]}],&quot;restaurant&quot;:31514}\" id=\"1610399\" title=\"Editar\" class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"productQuantity dropdown\" title=\"Seleccionar cantidad\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"qty_1610399\" class=\"\" id=\"qty_1610399\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\" selected=\"selected\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"name\">Aspirina</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"price\">$395</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"remove\"><button type=\"button\" class=\"button none\" title=\"Quitar\">Quitar</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li data-json=\"{&quot;product&quot;:1665461,&quot;name&quot;:&quot;Promo - Muzzarrella 3 x 2&quot;,&quot;quantity&quot;:1,&quot;restaurant&quot;:31514,&quot;optionGroups&quot;:[]}\" id=\"1665461\" title=\"Editar\" class=\"modified seen\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"productQuantity dropdown\" title=\"Seleccionar cantidad\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"qty_1665461\" class=\"\" id=\"qty_1665461\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\" selected=\"selected\">1</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"name\">Zolven</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"price\">$270</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"remove\"><button type=\"button\" class=\"button none\" title=\"Quitar\">Quitar</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<section id=\"subtotal\" class=\"prefooterinfo \">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"description\">Subtotal</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"price\">$665</div>\r\n");
      out.write("\t\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<section id=\"deliveryType\" class=\"prefooterinfo\" data-value=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"data\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span title=\"8 de Octubre 2486\">                \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tDelivery para 8 de Octubre 2486\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<section id=\"totalPrice\" class=\"prefooterinfo\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"description\">Total</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"price\">$665</div>\r\n");
      out.write("\t\t\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<footer>    \r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-success\">Realizar Pedido</button>\r\n");
      out.write("\t\t\t\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"cartOverlay\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<svg class=\"spinner\" width=\"65px\" height=\"65px\" viewBox=\"0 0 66 66\" xmlns=\"http://www.w3.org/2000/svg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<circle class=\"circle\" fill=\"none\" stroke-width=\"2.5\" stroke-linecap=\"round\" cx=\"33\" cy=\"33\" r=\"30\"></circle>\r\n");
      out.write("\t\t\t\t\t\t\t</svg>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>    \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</aside>\r\n");
      out.write("-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<footer class=\"footer\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t<p>Ingeniería de Software III</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"list-inline text-right\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Inicio</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Mis Calificaciones</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Contacto</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"js/jquery.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
