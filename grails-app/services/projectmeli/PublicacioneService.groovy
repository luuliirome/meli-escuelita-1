package projectmeli

import grails.transaction.Transactional

@Transactional
class PublicacioneService {

    List<Publicacion> getPublicacionesByKeyWord(String palabra){
		return  Publicacion.findAllByTituloLike("%"+palabra+"%");
	}
}
