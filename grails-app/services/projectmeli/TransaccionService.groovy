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
		Compra c = Compra.findByCompradorAndPublicacion(comprador,publi);
		c.calificado=true;
		saveCompra(c);
	}
	
	void rateBuyer(Usuario vendedor, Publicacion publi) {
		Venta v = Venta.findByVendedorAndPublicacion(vendedor,publi);
		v.calificado=true;
		saveVenta(v);
	}
}
