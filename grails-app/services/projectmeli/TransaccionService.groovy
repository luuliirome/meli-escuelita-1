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
}
