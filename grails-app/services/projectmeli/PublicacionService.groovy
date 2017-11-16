package projectmeli

import grails.transaction.Transactional
import projectmeli.Publicacion

@Transactional
class PublicacionService {

    List<Publicacion> getPublicacionesByKeyWord(String palabra){
		return  Publicacion.findAllByTituloLike("%"+palabra+"%");
	}
}
