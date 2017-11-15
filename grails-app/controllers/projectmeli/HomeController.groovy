package projectmeli

class HomeController {

    def index() {
		
		
        redirect(controller: 'login', action: 'index')
		
    }
}
