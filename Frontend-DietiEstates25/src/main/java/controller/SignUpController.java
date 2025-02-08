package controller;

import gui.SignUpFrame;

public class SignUpController {
	private SignUpFrame signUpFrame;
	
	public SignUpController(SignUpFrame signUpFrame) {
		
	}

	public void signUp(String email, String nome, String cognome, String password) throws Exception {
		if(verificaCampi(email, nome, cognome, password)) {
			//chiamata rest saveUtente
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}

	private boolean verificaCampi(String email, String nome, String cognome, String password) {
		return !email.isBlank()&&!nome.isBlank()&&!cognome.isBlank()&&!password.isBlank();
	}

}
