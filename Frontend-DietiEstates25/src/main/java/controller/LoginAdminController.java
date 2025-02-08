package controller;

import dto.Agenzia;
import dto.Amministratore;
import gui.LoginAdminFrame;

public class LoginAdminController {
	private LoginAdminFrame loginAdminFrame;
	
	public LoginAdminController(LoginAdminFrame loginAdminFrame) {
		this.loginAdminFrame=loginAdminFrame;
	}
	
	public Amministratore login(String nomeAdmin, String password) throws Exception{
		if(!nomeAdmin.isBlank() && !password.isBlank()) {
			//chiamata rest per login amministratore, ritorna amministratore
			Agenzia agency=new Agenzia("first","agency",".com");
			Amministratore admin=new Amministratore("admin1","paSsword1@",agency);
			return admin;
		}else
		{
			throw new Exception("Compilare i campi");
		}
	}
	
}
