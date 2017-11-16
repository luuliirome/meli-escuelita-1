package projectmeli

class PublicacionController {
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	
    def index() {
		
	}
	
	def redirectToPublicationView(){
		render(view: "/publicacion/main", model: [usuario: params.mail]);
	}
	
	def createPublication(){
		Usuario user = UsuarioService.getUserByEmail(params.mail);
		Publicacion publicacion = new Publicacion(autor: user,  titulo: params.tiulo, precio: params.precio, desripcion:params.detalles);
		PublicacionService.savePublication(publicacion);
		render(view: "/index");
	}
	
	def cancelCreation(){
		render(view: "/index");
	}
}
