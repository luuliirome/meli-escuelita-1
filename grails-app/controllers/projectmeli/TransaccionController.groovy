package projectmeli

class TransaccionController {

	static allowedMethods = [index: 'POST'];
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	TransaccionService TransaccionService = new TransaccionService();
	
	
    def index() { 
		
		Usuario vendedor = UsuarioService.getUserByEmail(params.autor);
		Usuario comprador = UsuarioService.getUserByEmail(params.usuario);
		
		Publicacion pub = PublicacionService.finishSell(params.titulo,vendedor);

		Transaccion transaccion = new Transaccion(comprador: comprador, publicacion: pub, vendedor: vendedor);
		TransaccionService.saveTransaccion(transaccion);

		
		render(view: "/transaccion/index", model: [url: params.url, nuevo: params.nuevo, autor: params.autor, titulo: params.titulo])
	}
	
	def viewPurchases(){
		List<Transaccion> compras = UsuarioService.getCompras(params.mail);
		render(view : "/transaccion/showCompras", model: [mail: params.mail, compras: compras]);
	}
	
}
