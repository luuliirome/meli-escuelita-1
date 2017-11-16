package projectmeli

class CompraController {

	static allowedMethods = [index: 'POST'];
	
    def index() { 
		println params.url
		render(view: "/compra/index", model: [url: params.url, nuevo: params.nuevo, autor: params.autor, titulo: params.titulo])
	}
	
}
