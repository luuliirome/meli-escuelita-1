package projectmeli

import grails.transaction.Transactional

@Transactional
class TransaccionService {

    void saveTransaccion(Transaccion c){
		c.save();
	}
	
	
	void rateSeller(Usuario comprador, Publicacion publi,Usuario vendedor) {
		Transaccion c = Transaccion.findByCompradorAndPublicacionAndVendedorAndCalificadoComprador(comprador,publi,vendedor,false);
		c.calificadoVendedor=true;
		c.save();
	}
	
	void rateBuyer(Usuario vendedor, Publicacion publi, Usuario comprador) {
		Transaccion v = Transaccion.findByVendedorAndPublicacionAndCompradorAndCalificadoVendedor(vendedor,publi, comprador,false);
		v.calificadoComprador=true;
		v.save();
	}
}
