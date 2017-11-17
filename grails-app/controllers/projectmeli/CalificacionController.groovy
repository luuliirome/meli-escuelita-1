package projectmeli

class CalificacionController {
	
	static allowedMethods = [calificarVendedor: 'POST', calificarComprador: 'POST'];
	
	//TransaccionService TransaccionService = new TransaccionService();
	UsuarioService UsuarioService = new UsuarioService();

	def calificarVendedor(){
		Usuario vendedor = UsuarioService.getUserByEmail(params.usuario);
		Publicacion pub = PublicacionService.finishSell(params.titulo,vendedor);
		
		//TransaccionService.rateSeller(vendedor, pub);
		UsuarioService.rateUser(vendedor,params.calificacion);
	}
	
	def calificarComprador(){
		
		Usuario comprador = UsuarioService.getUserByEmail(params.usuario);
		Publicacion pub = PublicacionService.finishSell(params.titulo,comprador);
		
		//TransaccionService.rateBuyer(comprador, pub);
		UsuarioService.rateUser(comprador,params.calificacion);
		
	}
	
	
}
