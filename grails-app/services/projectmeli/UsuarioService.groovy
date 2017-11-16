package projectmeli

import grails.transaction.Transactional
import projectmeli.Usuario

@Transactional
class UsuarioService {


	Usuario getUserByEmail(String email){
		return Usuario.findByMail(email);
	}
	
}
