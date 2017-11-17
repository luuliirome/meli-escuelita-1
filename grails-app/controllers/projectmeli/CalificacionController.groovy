package projectmeli

class CalificacionController {
	
	static allowedMethods = [calificarVendedor: 'POST', calificarComprador: 'POST'];
	
	TransaccionService TransaccionService = new TransaccionService();
	PublicacionService PublicacionService = new PublicacionService();
	UsuarioService UsuarioService = new UsuarioService();

	def calificarVendedor(){
		
		Usuario comprador = UsuarioService.getUserByEmail(params.mail);
		Usuario vendedor = UsuarioService.getUserByEmail(params.autor);
		Publicacion pub = PublicacionService.getPublicacion(params.titulo,vendedor);
		
		TransaccionService.rateSeller(comprador, pub,vendedor);
		UsuarioService.rateUser(vendedor,params.calificacion.toInteger());
		
		List<Transaccion> compras = UsuarioService.getCompras(params.mail);
		render(view : "/transaccion/showCompras", model: [mail: params.mail, compras: compras]);
		
	}
	
	def calificarComprador(){
		
		Usuario comprador = UsuarioService.getUserByEmail(params.comprador);
		Usuario vendedor = UsuarioService.getUserByEmail(params.vendedor);
		Publicacion pub = PublicacionService.getPublicacion(params.titulo,vendedor);
		
		TransaccionService.rateBuyer(vendedor, pub,comprador);
		UsuarioService.rateUser(comprador,params.calificacion.toInteger());
		
		
		List<Transaccion> ventas = UsuarioService.getVentas(params.vendedor);
		render(view : "/transaccion/showVentas", model: [mail: params.vendedor, ventas: ventas]);
	
	}
	
	
}
