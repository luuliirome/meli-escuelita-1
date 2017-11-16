<html>
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

	<h1>
		Resultado obtenido de buscar:
		${palabra}
	</h1>

	<g:if test="${lista.size() == 0 }"> No se obtuvieron resultados.
		<div align="right">
		<g:form action="index" controller="busqueda" method="POST">
		<input type="text" name="busqueda"> 
		<button type="submit">Busqueda</button>
		</g:form>
	</div>
	</g:if>
	<g:else>
		<div align="right">
		<g:form action="index" controller="busqueda" method="POST">
		<input type="text" name="busqueda"> 
		<button type="submit">Busqueda</button>
		</g:form>
	</div>
		<table>
			<tr>
				<th>Titulo</th>
				
				<th>Precio</th>
				<th>Autor</th>
				<th></th>
			</tr>
			<g:each var="each" in="${lista}">
				<tr>
					<td>
						${each.titulo}
					</td>
					<td>
						${each.precio}
					</td>
					<td>
						${each.autor.mail}
					</td>
					<td> 
						<g:form method="POST" action="goToPublicacion">
							<input type="hidden" name="publicacion" value="${each}">
							<button type="submit">Ir</button>
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>

	</g:else>
	

</body>
</html>