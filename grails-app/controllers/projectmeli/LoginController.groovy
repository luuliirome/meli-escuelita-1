package projectmeli

import projectmeli.Usuario;

class LoginController {
	
	UsuarioService UsuarioService = new UsuarioService();

	static allowedMethods = [login: 'POST'	]
	
	String titulo;
	//	List<Tag> tagsDeLaPublicacion = new LinkedList<Tag>();
		Usuario autor;
		double precio;
		String detalles;
		int cantidad;
		String imagen;
	
	
	def login(){
		
		Usuario usuario1 = new Usuario(mail:"luciainesromero@gmail.com", password:"87960");
		Publicacion publicacion1 = new Publicacion(autor:usuario1,titulo: "Barras proteicas", nuevo: true,cantidad: 1300, precio: 15, imagen:"https://http2.mlstatic.com/barras-proteicas-ultra-tech-banana-o-chocolate-caja-x-12-D_NQ_NP_699611-MLA20616043224_032016-F.jpg", detalles: "-" );		
		usuario1.save();
		publicacion1.save();
		
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
