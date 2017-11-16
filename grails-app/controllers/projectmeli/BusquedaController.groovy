package projectmeli

class BusquedaController {
	
	static allowedMethods = [index: 'POST', publicacion: 'POST'];
	
	PublicacionService PublicacionService = new PublicacionService();

    def index() { 
		
		List<Publicacion> listaPublicaciones = PublicacionService.getPublicacionesByKeyWord(params.busqueda, params.nuevo == "on", params.usado == "on");
		
		render(view: "/busqueda/search", model:[lista:listaPublicaciones,palabra: params.busqueda]);
		
	}
	
	def publicacion(){
		render(view: "/publicacion/index", model:[url: params.url, nuevo: params.nuevo, autor: params.autor, titulo: params.titulo, precio: params.precio, detalles: params.detalles]);
	}
}
