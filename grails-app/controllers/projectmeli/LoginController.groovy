package projectmeli

import projectmeli.Usuario;

class LoginController {
	
	UsuarioService UsuarioService = new UsuarioService();

	static allowedMethods = [login: 'POST'	]
	
    
	def login(){
		
		Usuario user = UsuarioService.getUserByEmail(params.mail);		
		
		if (user ==  null){
			render(view: "/index", model: [texto: "Email no esta registrado"])
		}
		else if (user.password != params.password){
			render(view: "/index", model: [texto: "Password Invalido"])
		}
		else{
			render(view: "/index", model: [texto: "Logueado", mail:params.mail])

		}
	}

	
}
