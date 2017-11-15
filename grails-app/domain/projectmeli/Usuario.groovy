package projectmeli

class Usuario {
	
	String username
	String password
    
	static constraints = {
		username size: 3..8
    }
}
