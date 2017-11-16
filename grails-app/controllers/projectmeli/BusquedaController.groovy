package projectmeli

class BusquedaController {

    def index() { 
		listaPublicaciones = PublicacionService.getPublicacionesByKeyWord(params.busqueda);
		
		render(view: "/search", model=[lista:listaPublicaciones,palabra: params.busqueda]);
		
	}
}
