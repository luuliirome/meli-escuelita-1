<head>
<meta name="layout" content="main" />
<title>Busqueda</title>
<style type="text/css" media="screen">
#status {
	background-color: #efe;
	border: .2em solid #fff;
	margin: 2em 2em 1em;
	padding: 1em;
	width: 12em;
	float: left;
	-moz-box-shadow: 0px 0px 1.25em #ccc;
	-webkit-box-shadow: 0px 0px 1.25em #ccc;
	box-shadow: 0px 0px 1.25em #ccc;
	-moz-border-radius: 0.6em;
	-webkit-border-radius: 0.6em;
	border-radius: 0.6em;
}

.ie6 #status {
	display: inline;
	/* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

.button {
	background-color: #0c0ca5;
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
	height: 30px;
}

#status ul {
	font-size: 0.9em;
	list-style-type: none;
	margin-bottom: 0.6em;
	padding: 0;
}

#status li {
	line-height: 1.3;
}

#status h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin: 0 0 0.3em;
}

#page-body {
	margin: 2em 1em 1.25em 18em;
}

h2 {
	margin-top: 1em;
	margin-bottom: 0.3em;
	font-size: 1em;
}

p {
	line-height: 1.5;
	margin: 0.25em 0;
}

#controller-list ul {
	list-style-position: inside;
}

#controller-list li {
	line-height: 1.3;
	list-style-position: inside;
	margin: 0.25em 0;
}

@media screen and (max-width: 480px) {
	#status {
		display: none;
	}
	#page-body {
		margin: 0 1em 1em;
	}
	#page-body h1 {
		margin-top: 0;
	}
}
</style>
</head>
<body>

		<div align="right">
		<g:form action="index" controller="busqueda" method="POST">
		<input type="text" name="busqueda"> 
		<button class="button" type="submit">Busqueda</button>  &nbsp;
		</g:form>
	</div>
	<g:if test="${session.user != autor}">
	<h2>
		Estas a un paso de tener lo que queres!
	___________________________________________________________________________________________________________
		<br>
	</h2>
	</g:if>
	<g:else>
	<h2>
		Chequea tu publicacion
	___________________________________________________________________________________________________________
		<br>
	</h2>
	</g:else>
	
	<div align="center">
		<h7><font color="grey">${titulo}</font> </h7>
	</div>
	
	<table>
<tbody>
<tr>
<td>
	<img src="${url}" height="250" width="250" border="2">
</td>
<td>
	<h2>Precio:</h2> <p style="color:green;">${precio}</p>
	<h2>Detalles:</h2><p>${detalles}</p>
</td>
</tr>
</tbody>
</table>
	
	
	
	
	
	<g:if test="${session.user != autor}">
	<div align="right">
	<g:form method="POST" action="index" controller="transaccion">
		<input type="hidden" name="titulo" value="${titulo}" >
		<input type="hidden" name="autor" value="${autor}">
		<input type="hidden" name="usuario" value="${usuario}">
		<button class="button" type="submit">Comprar</button>
	</g:form>
	</div>
	</g:if>
	
</body>
</html>