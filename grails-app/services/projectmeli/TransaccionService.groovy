package projectmeli

import grails.transaction.Transactional

@Transactional
class TransaccionService {

    void saveCompra(Compra c){
		c.save();
	}
	
	void saveVenta(Venta v){
		v.save();
	}
	
	void rateSeller(Usuario comprador, Publicacion publi) {
		Compra c = Compra.findByCompradorAndPublicacionAndCalificado(comprador,publi,false);
		c.calificado=true;
		c.save();
	}
	
	void rateBuyer(Usuario vendedor, Publicacion publi, Usuario comprador) {
		Venta v = Venta.findByVendedorAndPublicacionAndCompradorAndCalificado(vendedor,publi, comprador,false);
		v.calificado=true;
		v.save();
	}
}
