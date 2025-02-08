package controller;

import gui.CreaAmministratoreFrame;

public class CreaAmministratoreController {
	private CreaAmministratoreFrame creaAmministratoreFrame;
	
	public CreaAmministratoreController(CreaAmministratoreFrame creaAmministratoreFrame) {
		this.creaAmministratoreFrame=creaAmministratoreFrame;
	}

	public void creaAmministratore(String nomeAdmin, String password) throws Exception {
		if(verificaCampi(nomeAdmin, password)) {
			//chiamata rest saveAmministratore
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}
	private boolean verificaCampi(String nomeAdmin, String password) {
		return !nomeAdmin.isBlank()&&!password.isBlank();
	}
}
