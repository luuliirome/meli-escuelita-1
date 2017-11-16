package projectmeli

class BusquedaController {
	
	static allowedMethods = [index: 'POST', goToPublicacion: 'POST'];
	
	PublicacionService PublicacionService = new PublicacionService();

    def index() { 
		
		List<Publicacion> listaPublicaciones = PublicacionService.getPublicacionesByKeyWord(params.busqueda);
		
		render(view: "/busqueda/search", model:[lista:listaPublicaciones,palabra: params.busqueda]);
		
	}
	
	def goToPublicacion(){
		render(view: "/publicacion", model:[publicacion:publicacion]);
	}
}
