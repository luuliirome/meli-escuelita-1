package projectmeli

class CompraController {

	static allowedMethods = [index: 'POST'];
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	
    def index() { 
		
		Usuario user = UsuarioService.getUserByEmail(params.autor);
		Usuario comprador = UsuarioService.getUserByEmail("guidomaceira@gmail.com");
		Publicacion pub = PublicacionService.finishSell(params.titulo,user);
		
		Compra compra = new Compra(comprador: comprador, publicacion: pub);
		compra.save();
		
		
		render(view: "/compra/index", model: [url: params.url, nuevo: params.nuevo, autor: params.autor, titulo: params.titulo])
	}
	
	def viewPurchases(){
		List<Compra> compras = UsuarioService.getCompras(params.mail);
		render(view : "/compra/showCompras", model: [mail: params.mail, compras: compras]);
	}
	
}
