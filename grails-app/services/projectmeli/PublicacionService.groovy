package projectmeli

import grails.transaction.Transactional
import projectmeli.Publicacion

@Transactional
class PublicacionService {

    List<Publicacion> getPublicacionesByKeyWord(String palabra){
		return  Publicacion.findAllByTituloLike("%"+palabra+"%");
	}
	
	void savePublication(Publicacion publicacion){
	//	println "estoy pasando por guardar la publicacion \n";
		publicacion.save();
	}
	
	Publicacion finishSell(String titulo, Usuario autor){
		
		Publicacion p = Publicacion.findByTituloAndAutor(titulo,autor);
		
		p.cantidad --;
		return p;
		
	}
}
