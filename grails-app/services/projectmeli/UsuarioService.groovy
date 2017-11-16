package projectmeli

import grails.transaction.Transactional
import projectmeli.Usuario

@Transactional
class UsuarioService {


	Usuario getUserByEmail(String email){
		return Usuario.findByMail(email);
	}
	List<Compra> getCompras(String email){
		Usuario user = getUserByEmail(email);
		return Compra.findAllByComprador(user);
	}	
}
