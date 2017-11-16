package projectmeli

class PublicacionController {
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	
    def index() {
		
	}
	
	def redirectToPublicationView(){
		
		render(view: "/publicacion/main", model: [mail: params.mail]);
	}
	
	def createPublication(){
		Usuario user = UsuarioService.getUserByEmail(params.mail);
		Publicacion publicacion = new Publicacion(autor: user,  titulo: params.titulo, precio: params.precio, detalles:params.detalles, nuevo: true);
		PublicacionService.savePublication(publicacion);
		render(view: "/index", model: [mail: params.mail, texto: "Logueado"]);
	}
	
	def cancelCreation(){
		render(view: "/index", model: [mail: params.mail, texto: "Logueado"]);
	}
}
