package projectmeli

import projectmeli.Usuario;

class LoginController {

	static allowedMethods = [loginCheck: 'POST'	]
	
    def index() {
		render(view: "/index")
	}
	
	def login(){
		
		if (Usuario.findByMailAndPassword(params.mail, params.password)){
			def usuario = params;
			render(view: "/index", model: [texto: "Logueado"])
		}
		else{
			render(view: "/index", model: [texto: "Error de Logueo"])
		}
	}

	
}
