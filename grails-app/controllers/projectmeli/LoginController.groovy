package projectmeli

import projectmeli.Usuario;

class LoginController {

	static allowedMethods = [login: 'POST'	]
	
    def index() {

		def usuario1 = new Usuario(mail:"guidomaceira@gmail.com", password:"1234");
		def usuario2 = new Usuario(mail:"luciainesromero@gmail.com", password:"5678");
		def usuario3 = new Usuario(mail:"patosabogal@gmail.com", password:"90111213");
		def usuario4 = new Usuario(mail:"gregoriofreidin@gmail.com", password:"141516171819");
		usuario1.save();
		usuario2.save();
		usuario3.save();
		usuario4.save();
		render(view: "/index")
	}
	
	def login(){
		
		def usuario1 = new Usuario(mail:"guidomaceira@gmail.com", password:"1234");
		usuario1.save();
		
		if (Usuario.findByMailAndPassword(params.mail, params.password)){
			render(view: "/index", model: [texto: "Logueado", mail: params.mail])
		}
		else{
			render(view: "/index", model: [texto: "Usuario inexistente"])
		}
	}

	
}
