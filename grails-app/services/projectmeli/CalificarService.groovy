package projectmeli

import grails.transaction.Transactional

@Transactional
class CalificarService {
	
    void rateSeller(Usuario comprador, Publicacion publi) {
		Compra c = Compra.findByCompradorAndPublicacion(comprador,publi);
		c.calificado=true;
		c.save();
    }
	
	void rateBuyer(Usuario vendedor, Publicacion publi) {
		Venta v = Venta.findByVendedorAndPublicacion(vendedor,publi);
		v.calificado=true;
		v.save();
	}
	
	
}
