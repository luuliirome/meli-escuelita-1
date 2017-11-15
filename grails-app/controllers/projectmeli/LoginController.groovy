package projectmeli

import projectmeli.Usuario;

class LoginController {

	static allowedMethods = [login: 'POST'	]
	
    def index() {
		render(view: "/index")
	}
	
	def login(){
		
		//Esto esta harcodeado para probar un usuario
		//def usuariou = new Usuario(mail:"Guido",password: "1234");
		//usuariou.save();
		if (Usuario.findByMailAndPassword(params.mail, params.password)){
			//def usuario = params;
			render(view: "/index", model: [texto: "Logueado"])
		}
		else{
			render(view: "/index", model: [texto: "Error de Logueo"])
		}
	}

	
}
