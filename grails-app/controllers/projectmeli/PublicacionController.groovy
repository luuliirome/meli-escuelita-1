package projectmeli

class PublicacionController {
	UsuarioService UsuarioService = new UsuarioService();
	PublicacionService PublicacionService = new PublicacionService();
	
    def index() {
		
	}
	
	def redirectToPublicationView(){
		println params.mailUsuario;
		render(view: "/publicacion/main", model: [mail: params.mail]);
	}
	
	def createPublication(){
		println params.email
		Usuario user = UsuarioService.getUserByEmail(params.email);
		Publicacion publicacion = new Publicacion(autor: user,  titulo: params.titulo, precio: params.precio, detalles:params.detalles);
		PublicacionService.savePublication(publicacion);
		render(view: "/index");
	}
	
	def cancelCreation(){
		render(view: "/index");
	}
}
