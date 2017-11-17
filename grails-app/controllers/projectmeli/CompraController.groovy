package projectmeli

class CompraController {

	static allowedMethods = [index: 'POST'];
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	TransaccionService TransaccionService = new TransaccionService();
	
	
	
    def index() { 
		
		Usuario vendedor = UsuarioService.getUserByEmail(params.autor);
		Usuario comprador = UsuarioService.getUserByEmail(params.usuario);
		println params.usuario;
		Publicacion pub = PublicacionService.finishSell(params.titulo,vendedor);

		Venta venta = new Venta(comprador: comprador, publicacion: pub, vendedor: vendedor);
		TransaccionService.saveVenta(venta);
		Compra compra = new Compra(comprador: comprador, publicacion: pub);
		TransaccionService.saveCompra(compra);
		
		
		render(view: "/compra/index", model: [url: params.url, nuevo: params.nuevo, autor: params.autor, titulo: params.titulo])
	}
	
	def viewPurchases(){
		List<Compra> compras = UsuarioService.getCompras(params.mail);
		render(view : "/compra/showCompras", model: [mail: params.mail, compras: compras]);
	}
	
}
