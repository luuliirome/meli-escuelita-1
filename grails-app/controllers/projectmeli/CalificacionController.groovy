package projectmeli

class CalificacionController {
	
	static allowedMethods = [calificarVendedor: 'POST', calificarComprador: 'POST'];
	
	TransaccionService TransaccionService = new TransaccionService();
	PublicacionService PublicacionService = new PublicacionService();
	UsuarioService UsuarioService = new UsuarioService();

	def calificarVendedor(){
		
		Usuario vendedor = UsuarioService.getUserByEmail(params.autor);
		Publicacion pub = PublicacionService.finishSell(params.titulo,vendedor);
		
		TransaccionService.rateSeller(vendedor, pub);
		UsuarioService.rateUser(vendedor,params.calificacion);
		
		List<Compra> compras = UsuarioService.getCompras(params.mail);
		render(view : "/compra/showCompras", model: [mail: params.mail, compras: compras]);
		
	}
	
	def calificarComprador(){
		
		Usuario comprador = UsuarioService.getUserByEmail(params.autor);
		Publicacion pub = PublicacionService.finishSell(params.titulo,comprador);
		
		TransaccionService.rateBuyer(comprador, pub);
		UsuarioService.rateUser(comprador,params.calificacion);
		
		
		List<Compra> compras = UsuarioService.getCompras(params.mail);
		render(view : "/compra/showCompras", model: [mail: params.mail, compras: compras]);
		
	}
	
	
}
