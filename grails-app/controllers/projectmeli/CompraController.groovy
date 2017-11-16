package projectmeli

class CompraController {

	static allowedMethods = [index: 'POST'];
	
    def index() { 
		
		render(view: "/compra/index", model: [autor: params.autor, titulo: params.titulo])
	}
	
}
