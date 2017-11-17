<html>
<head>
<meta name="layout" content="main" />
<title>Mis Compras</title>
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
		Mis Compras:
	</h1>

	<g:if test="${compras.size() == 0 }"> No se han realizado compras.
	
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
				<th>Estado</th>
				<th>Calificar</th>
				<th></th>
			</tr>
			<g:each var="each" in="${compras}">
				<g:if test="${each.publicacion.cantidad > 0}">
				<tr>
					<td>
						${each.publicacion.titulo}
					</td>
					<td>
						${each.publicacion.precio}
					</td>
					<td>
						${each.publicacion.autor.mail}
					</td>
					<td>
						<g:if test="${each.publicacion.nuevo == true}">Nuevo</g:if>
						<g:else> Usado </g:else>
					</td>
					<td>
						<g:if test="${!each.calificado}" >
							<g:form method="POST" action="calificarVendedor" controller="calificacion">
								<input type="hidden" name="titulo" value="${each.publicacion.titulo}">
								<input type="hidden" name="autor" value="${each.publicacion.autor.mail}">
								<input type="hidden" name="mail" value="${mail}">
								<input type="hidden" name="calificacion" value=1>
								<button type="submit">↑</button>
							</g:form>
							<g:form method="POST" action="calificarVendedor" controller="calificacion">
								<input type="hidden" name="titulo" value="${each.publicacion.titulo}">
								<input type="hidden" name="autor" value="${each.publicacion.autor.mail}">
								<input type="hidden" name="mail" value="${mail}">
								<input type="hidden" name="calificacion" value=-1>
								<button type="submit">↓</button>
							</g:form>
						</g:if>
					</td>
					<td> 
						<g:form method="POST" action="publicacion" controller="busqueda">
							<input type="hidden" name="titulo" value="${each.publicacion.titulo}">
							<input type="hidden" name="detalles" value="${each.publicacion.detalles}">
							<input type="hidden" name="precio" value="${each.publicacion.precio}">
							<input type="hidden" name="autor" value="${each.publicacion.autor.mail}">
							<input type="hidden" name="url" value="${each.publicacion.imagen}">
							<input type="hidden" name="nuevo" value="${each.publicacion.nuevo}">
							<button type="submit">Ir</button>
						</g:form>
					</td>
				</tr>
				</g:if>
			</g:each>
		</table>

	</g:else>
	

</body>
</html>