package projectmeli

class LoginController {
	
	static allowedMethods = [loginCheck: 'POST'	]

    def login() {
		
	}
	
	def indexLogueado(){
		
	}
	
	def loginCheck(){
		def nuevoUsuario = new Usuario(username:"Guido",password:"1234");
		nuevoUsuario.save();
		if (Usuario.findByUsernameAndPassword(params.username, params.password)){
			render (view: "/login/indexLogueado")
		}
		else{
			render (view: "/login/error")
		}
	}
	
	def error(){
		
	}
}
