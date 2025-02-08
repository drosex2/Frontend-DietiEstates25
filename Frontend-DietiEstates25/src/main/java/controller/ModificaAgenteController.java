package controller;

import gui.CreaAgenteFrame;

public class ModificaAgenteController {
	private CreaAgenteFrame creaAgenteFrame;

	public ModificaAgenteController(CreaAgenteFrame creaAgenteFrame) {
		this.creaAgenteFrame=creaAgenteFrame;
	}

	public void creaAgente(String email, String nome, String cognome, String password) throws Exception {
		if(verificaCampi(email, nome, cognome, password)) {
			//chiamata rest saveAgente
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}

	private boolean verificaCampi(String email, String nome, String cognome, String password) {
		return !email.isBlank()&&!nome.isBlank()&&!cognome.isBlank()&&!password.isBlank();
	}
	
	

}
