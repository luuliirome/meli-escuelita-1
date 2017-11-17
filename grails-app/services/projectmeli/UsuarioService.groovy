package projectmeli

import grails.transaction.Transactional
import projectmeli.Usuario

@Transactional
class UsuarioService {


	Usuario getUserByEmail(String email){
		return Usuario.findByMail(email);
	}
	List<Transaccion> getCompras(String email){
		Usuario user = getUserByEmail(email);
		return Transaccion.findAllByComprador(user);
	}	
	
	List<Transaccion> getVentas(String email){
		Usuario user = getUserByEmail(email);
		return Transaccion.findAllByVendedor(user);
	}
	
	void rateUser(Usuario user, int calificacion){
		user.calificacion += calificacion;
		user.save();
	}
}
