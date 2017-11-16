package projectmeli

import projectmeli.Usuario;

class LoginController {
	
	UsuarioService UsuarioService = new UsuarioService();

	static allowedMethods = [login: 'POST'	]
	
    
	def login(){
		
		def usuario1 = new Usuario(mail:"guidomaceira@gmail.com", password:"1234");
		usuario1.save();
		Usuario user = UsuarioService.getUserByEmail(params.mail);
		Publicacion publicacion = new Publicacion(titulo:"Guido", autor:usuario1, precio: 0.09, detalles:"Un chico especial :)");
		publicacion.save();
		
		if (user ==  null){
			render(view: "/index", model: [texto: "Email no esta registrado"])
		}
		else if (user.password != params.password){
			render(view: "/index", model: [texto: "Password Invalido"])
		}
		else{
			render(view: "/index", model: [texto: "Logueado"])

		}
	}

	
}
