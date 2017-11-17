package projectmeli

import grails.transaction.Transactional

@Transactional
class TransaccionService {

    void saveTransaccion(Transaccion c){
		c.save();
	}
	
	
	void rateSeller(Usuario comprador, Publicacion publi) {
		Transaccion c = Transaccion.findByCompradorAndPublicacionAndCalificadoUsuario(comprador,publi,false);
		c.calificadoVendedor=true;
		c.save();
	}
	
	void rateBuyer(Usuario vendedor, Publicacion publi, Usuario comprador) {
		Transaccion v = Venta.findByVendedorAndPublicacionAndCompradorAndCalificadoVendedor(vendedor,publi, comprador,false);
		v.calificadoComprador=true;
		v.save();
	}
}
