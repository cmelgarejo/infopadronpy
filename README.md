# infopadronpy

Este es un proyecto con la intención de encapsular los servicios web de todos los partidos políticos con el afán de tener acceso a nuestra información.

En Paraguay, se dá el caso en el que nos afilian/inscriben sin consentimiento a los partidos políticos, y para acceder a -nuestra- información debemos acudir en persona o por línea telefónica al TSJE (http://tsje.gov.py) lo cual es poco práctico; esta "multiafiliación" expone a las personas a una multa excesiva (200 jornales minimos) e inclusive cárcel. Es bien sabido que hasta figuran votos de personas ya fallecidas o infantes, qué impiden hacernos votar en distintas internas partidarias y exponernos a juicio? La poca jurisdicción del TSJE nos obliga a estar informados y tomar en nuestras manos la acción de verificar que no estén jugando con nuestra opinión.

Pueden ayudar a juntar más servicios de padrones, que sepan sean públicos, hasta ahora tengo dos ejemplos de solicitud de webservices públicos:

###ANR

Request: 
curl "http://www.anr.org.py/padron.php" -H "Origin: http://www.anr.org.py" -H "Accept-Encoding: gzip, deflate" -H "Accept-Language: es-419,es;q=0.8,en-US;q=0.6,en;q=0.4,pt;q=0.2,fr;q=0.2" -H "User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36" -H "HTTPS: 1" -H "Content-Type: application/x-www-form-urlencoded" -H "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8" -H "Cache-Control: max-age=0" -H "Referer: http://www.anr.org.py/padron.php" -H "Connection: keep-alive" -H "X-FirePHP-Version: 0.0.6" --data "ci=9999999&buscar2=Buscar" --compressed

Response:
```html
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<title>ANR - Asociaci&oacute;n Nacional Republicana</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="lang" content="es" />
<meta name="author" content="PARTIDO COLORADO" />
<meta name="organization" content="APP_ORG" />
<meta name="locality" content="Asunci&oacute;n, Paraguay" />
<meta name="keywords" content="paraguay, anr, partido colorado, organizaci&oacute;n, pol&iacute;tico, pol&iacute;tica" />
<meta name="description" content="Asociaci&oacute;n Nacional Republicana" />
<meta name="cache-control" content="Public">
<link rel="icon" href="favicon.ico" type="image/ico" />
<link rel="shortcut icon" href="favicon.ico" type="image/ico" />

    <link rel="stylesheet" type="text/css" href="http://www.anr.org.py/css/estilos.css?12072012" media="screen">
    <link rel="stylesheet" href="http://www.anr.org.py/css/prettyPhoto.css" type="text/css" media="screen" title="" charset="utf-8" />
    <link rel="stylesheet" href="http://www.anr.org.py/css/anythingslider.css">    
    
    <script src="http://www.anr.org.py/js/jquery.js"></script>
    <script type="text/javascript" src="http://www.anr.org.py/js/swfobject.js"></script>
    <script type="text/javascript" src="http://www.anr.org.py/js/jquery.prettyPhoto.js" charset="utf-8"></script>
	<script src="http://www.anr.org.py/js/jquery.anythingslider.min.js"></script>
    <!-- AnythingSlider initialization -->
    <!-- Older IE stylesheet, to reposition navigation arrows, added AFTER the theme stylesheet -->
    <!--[if lte IE 7]>
    <link rel="stylesheet" href="http://www.anr.org.py/css/anythingslider-ie.css" type="text/css" media="screen" />
    <![endif]-->

	<style type="text/css">
        @import "css/jquery.countdown.css";
        #defaultCountdown { width: 240px; height: 45px; }
    </style>

    <script type="text/javascript" src="js/jquery.countdown.js"></script>
    <script type="text/javascript" src="js/jquery.countdown-es.js" charset="utf-8"></script>
    <script type="text/javascript">
	
	function serverTime() { 
    	var time = null; 
		$.ajax({url: 'horaserver.php', 
			async: false, dataType: 'text', 
			success: function(text) { 
				time = new Date(text); 
			}, error: function(http, message, exc) { 
				time = new Date(); 
		}}); 
		return time; 
	}
	
    $(function () {
        var austDay = serverTime();
        austDay = new Date(austDay.getFullYear(), 4 - 1, 21);
        $('#defaultCountdown').countdown({until: austDay});
    });
    </script>

</head>
<body>

<div id="cabecera" class="contenedor" style="background-image:url(img/bgcab.jpg); background-repeat:no-repeat; background-position:top right;">
    	<div id="logo" class="logo">
    		<div class="espacio10"></div>
        	<a href="./"><img src="img/logo.jpg" alt="ANR" width="321" height="62" border="0" /></a>
  		</div>
    	
        <div class="menus">
        
			
            <div id="menutabs" class="menutabs">
                <ul>
				<li><a href="http://www.anr.org.py">Inicio</a></li>
		<li><a href="http://www.anr.org.py" rel="menu1">El Partido</a></li><li><a href="http://www.anr.org.py" rel="menu2">Autoridades</a></li><li><a href="http://www.anr.org.py" rel="menu3">Elecciones</a></li><li><a href="http://www.anr.org.py" rel="menu4">Servicios</a></li><li><a href="http://www.anr.org.py" rel="menu5">Documentos</a></li><li><a href="http://www.anr.org.py" rel="menu6">Multimedia</a></li><li><a href="http://www.anr.org.py" rel="menu8">Organización</a></li><li><a href="http://www.anr.org.py" rel="menu7">Contacto</a></li>      
                </ul>
            </div>
		<div id="menu1" class="dropmenudiv_b"><a href="http://www.anr.org.py/paginas.php?cod=1">Antecedentes Historicos</a><a href="http://www.anr.org.py/paginas.php?cod=3">Acta de fundación</a><a href="http://www.anr.org.py/paginas.php?cod=53">Ideologia</a><a href="http://www.anr.org.py/paginas.php?cod=4">Lideres Historicos del Partido</a><a href="http://www.anr.org.py/paginas.php?cod=9">Declaracion de Principios</a><a href="http://www.anr.org.py/paginas.php?cod=49">Credo Republicano</a><a href="http://www.anr.org.py/paginas.php?cod=54">Orientacion Politica</a><a href="http://www.anr.org.py/paginas.php?cod=35">Ex-Presidentes</a><a href="http://www.anr.org.py/paginas.php?cod=45">Organigramas</a></div><div id="menu2" class="dropmenudiv_b"><a href="http://www.anr.org.py/paginas.php?cod=2">La Presidencia</a><a href="http://www.anr.org.py/tribunal_partidario.php">Tribunal Electoral</a><a href="http://www.anr.org.py/paginas.php?cod=18">Tribunal de Conducta</a><a href="autorinac.php">Autoridades Nacionales</a><a href="autoridep.php">Autoridades Departamentales</a><a href="autorisec.php">Autoridades Seccionales</a></div><div id="menu3" class="dropmenudiv_b"><a href="http://www.anr.org.py/juzga2012inter.php">Elecciones Internas Presidenciales 09/12/2012</a><a href="http://www.anr.org.py/paginas.php?cod=69"> Elecciones Internas Partidarias 13/03/2011</a></div><div id="menu4" class="dropmenudiv_b"><a href="http://www.anr.org.py/paginas.php?cod=44">Como Afiliarme?</a><a href="http://www.anr.org.py/paginas.php?cod=38">Centro de Capacitación Técnico Superior</a><a href="http://www.anr.org.py/paginas.php?cod=46">Biblioteca Universitaria</a><a href="cedula.php">Solicitud de cedula partidaria</a><a href="responde.php">La Presidenta responde</a><a href="afiliaciones.php">Consulta sobre Afiliaciones</a><a href="http://www.anr.org.py/paginas.php?cod=32">Colorado Roga</a></div><div id="menu5" class="dropmenudiv_b"><a href="/descargas/files/ejecucion%20grandes%20rubros.pdf">Ejecución Presupuestaria 2012</a><a href="http://www.anr.org.py/paginas.php?cod=34">Reglamento Electoral</a><a href="http://www.anr.org.py/paginas.php?cod=36">Reglamento de la Junta de Gobierno</a><a href="http://www.anr.org.py/paginas.php?cod=59">Reglamento del Tribunal de conducta</a><a href="http://www.anr.org.py/paginas.php?cod=33">Código de Ética</a></div><div id="menu6" class="dropmenudiv_b"><a href="fotos.php">Galería de Fotos</a><a href="videos.php">Galería de Videos</a></div><div id="menu7" class="dropmenudiv_b"><a href="http://www.anr.org.py/paginas.php?cod=6">Localización</a><a href="http://www.anr.org.py/paginas.php?cod=65">Mapas de Seccionales</a></div><div id="menu8" class="dropmenudiv_b"><a href="http://www.anr.org.py/paginas.php?cod=48">Comision Central de la Mujer</a><a href="http://www.anr.org.py/paginas.php?cod=60">Asesoría Jurídica</a><a href="http://www.anr.org.py/paginas.php?cod=58">Planificacion ANR</a><a href="http://www.anr.org.py/paginas.php?cod=19">Dirección de Comunicaciones</a><a href="archivo.php">Archivo de noticias</a></div>
  	  </div><!-- Menus -->
      <div class="clear"></div>
            
</div><!-- Cabecera -->
<style>
.resuldato{
	-webkit-box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.4);
	-moz-box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.4);
	box-shadow: 0 -1px 5px rgba(0, 0, 0, 0.4); 
	padding:5px; 
	border-radius: 10px;
	-ms-border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	-khtml-border-radius: 10px;	
	background-color:#FFF;
	width:450px;
}
</style>


<div id="pagina" class="contenedor cuadropag">
<div style="margin-left:130px;">

  <div class="espacio10"></div>
  <div class="lin1">
    <div class="cuadroBGGris">
      <div class="lin2x">   <div class="espacio10"></div><span class="tit-rojo"> Padr&oacute;n Nacional</span>
    <div class="espacio5"></div>
	<div style="width:90px; float:left; display:inline; padding:5px;"><b>Ingrese N&deg; C.I.</b></div>
    <div style="width:450px; float:left; display:inline;">
    <form id="form2" name="form1" method="post" action="padron.php">
      <input type="text" name="ci" id="ci"  class="resuldato" style="width:100px; padding:5;" />&nbsp;&nbsp;
      <input name="buscar2" type="submit" class="cuadroBTRojo" id="buscar2" value="Buscar" />
    </form>
    </div>
    <div class="espacio10"></div>
  </div>
  <div class="clear"></div>

  
  
</div>
        <div class="clear"></div>
        <div class="espacio10"></div>

<div class="cuadroBGGris">




	<div style="margin-left:10px; padding-top:20px;">
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>NOMBRE Y APELLIDO</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato"><b>CHRISTIAN MELGAREJO BRESANOVICH</b></div>
        <div class="clear"></div>
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>Nro. de C.I.</b></div>
        <div style="width:130px; float:left; display:inline; margin-right:50px;" class="resuldato">9.999.999</div>
        <div class="clear"></div>
        <div class="espacio10"></div>      
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>DEPARTAMENTO</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato">CENTRAL</div>
        <div class="clear"></div>
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>DISTRITO</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato">LIMPIO</div>
        <div class="clear"></div>
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>ZONA</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato">LIMPIO</div>
        <div class="clear"></div>
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>SECCIONAL</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato">LIMPIO  2</div>
        <div class="clear"></div>		
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>LOCAL</b></div>
        <div style="width:450px; float:left; display:inline;" class="resuldato">COLEGIO SAN JOSE</div>
        <div class="clear"></div>
        <div class="espacio10"></div>
        <div style="width:130px; float:left; display:inline; padding:5px;"><b>MESA</b></div>
        <div style="width:130px; float:left; display:inline; margin-right:50px;" class="resuldato">108</div>
        <div style="width:100px; float:left; display:inline; padding:5px;"><b>ORDEN</b></div>
        <div style="width:150px; float:left; display:inline;" class="resuldato">108</div>
        <div class="clear"></div>
        <div class="espacio10"></div>
	</div>

    <div style="margin-left:10px;">

  <div class="espacio10"></div>
	</div>


</div>
</div>
<div class="espacio10"></div>
    	<div class="clear"></div>
</div><!--LIN 1 -->

	
</div><!-- PAGINA -->

<div class="clear"></div>

    <div id="pie-fondo" class="pie">

      <div class="contenedor">
        <div id="pie" class="pieA txt-pie-pagina">
          <strong>Direcci&oacute;n:</strong> 25 de Mayo  N&deg; 842  c/ Tacuary - Asunci&oacute;n, Paraguay<br />
          <strong>Tel&eacute;fonos:</strong> +595 (021) 452 749<br />
          <strong>Email:</strong> contacto@anr.org.py
          </div>
      </div>
        
      <div class="clear"></div>
        
      <div class="contenedor">  
        <div id="pie" class="pieA txt-pie-pagina">
        	<br />
            &copy; 2015 Asociaci&oacute;n Nacional Republicana - Partido Colorado
            <div class="clear"></div>
        </div>
       </div>
                
    <div class="clear"></div>
  </div><!-- fin pie-fondo -->

<!--/***********************************************
* Drop Down Tabs Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/-->
<script type="text/javascript" src="js/dropdowntabs.js"></script>
<script type="text/javascript">tabdropdown.init("menutabs");</script> 

<script type="text/javascript">
    
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-25579337-1']);
      _gaq.push(['_trackPageview']);
    
      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
    
    </script>

</body>
</html>
```
####Alternativo
URL: http://www.feednoticias.com/app/padrones/anr.php

POST /app/padrones/anr.php HTTP/1.1
Content-Length: 14
Content-Type: application/x-www-form-urlencoded
Host: www.feednoticias.com
Connection: Keep-Alive
User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)

cedula=9999999

HTTP/1.1 200 OK
Date: Thu, 23 Jul 2015 14:51:27 GMT
Server: Apache
X-Powered-By: PHP/5.3.29
Vary: Accept-Encoding,User-Agent
Connection: close
Transfer-Encoding: chunked
Content-Type: text/xml;charset=UTF-8
```xml
<resultados>
  <resultado>
    <ci>
      9.999.999
    </ci>
    <apellido>
      Melgarejo Bresanovich
    </apellido>
    <nombre>
      Christian
    </nombre>
    <dpto>
      Central
    </dpto>
    <districto>
      Limpio
    </districto>
    <zona>
      Limpio
    </zona>
    <seccional>
      Limpio  2
    </seccional>
    <local>
      Colegio San Jose
    </local>
    <mesa>
      108
    </mesa>
    <orden>108
    </orden>
  </resultado>
</resultados>
```

###PLRA

URL: http://190.128.194.162/ws/rcp/consulta.php?cc=9999999&op=1

GET /ws/rcp/consulta.php?cc=9999999&op=1 HTTP/1.1
Host: 190.128.194.162
Connection: Keep-Alive
User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)

HTTP/1.1 200 OK
Date: Thu, 23 Jul 2015 14:49:35 GMT
Server: Apache/2.2.24 (PowerStack)
Content-Length: 145
Connection: close
Content-Type: text/html; charset=UTF-8
```json
["9999999","CHRISTIAN","MELGAREJO","SAN LORENZO N\u00c2\u00ba5                      ","COL.NAC.CONCEPCION L.DE CHAVEZ","9","999"]
```

Información, sugerencias, código, servidores son todos bienvenidos :)
