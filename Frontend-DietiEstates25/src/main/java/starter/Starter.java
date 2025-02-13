package starter;

import java.util.List;

import javax.swing.JFrame;

import dto.Agente;
import dto.Amministratore;
import dto.Inserzione;
import dto.Utente;
import gui.*;

public class Starter {
	private static final String BASE_URI="http://3.89.254.227:8080/api/1.0/";
	private LoginFrame loginFrame;
	private LoginAdminFrame loginAdminFrame;
	private HomePageAdminFrame homePageAdmin;
	private HomePageUtenteFrame homePageUtente;
	private HomePageAgenteFrame homePageAgente;
	private CreaAgenteFrame creaAgenteFrame;
	private SignUpFrame signUpFrame;
	private CreaAmministratoreFrame creaAmministratoreFrame;
	private ModificaPasswordFrame modificaPasswordFrame;
	private VisualizzaInserzioni visualizzaInserzioni;
	private ModificaInserzioneFrame modificaInserzioneFrame;
	
	
	public Starter() {
		loginFrame=new LoginFrame(this);
		loginFrame.setVisible(true);
	}
	
	
	
    public static void main(String[] args) {
        Starter starter= new Starter();
    }
    
    public void switchLoginToLoginAdmin() {
    	loginAdminFrame=new LoginAdminFrame(this);
    	loginFrame.setVisible(false);
    	loginAdminFrame.setVisible(true);
    	
    }



	public void switchLoginAdminToLogin() {
		loginAdminFrame.setVisible(false);
		loginFrame.setVisible(true);
		
	}



	public void switchLoginAdminToHomePageAdmin(Amministratore admin,String token) {
		homePageAdmin= new HomePageAdminFrame(this,admin,token);
		loginAdminFrame.setVisible(false);
		homePageAdmin.setVisible(true);
		
	}
	public void logout(JFrame frameAttuale) {
		frameAttuale.setVisible(false);
		loginFrame.setVisible(true);
	}
	public void logoutAdmin() {
		homePageAdmin.setVisible(false);
		loginFrame.setVisible(true);
		
	}



	public void switchHomePageAdminToCreaAgenteFrame(Amministratore adminConnesso, String token) {
		creaAgenteFrame= new CreaAgenteFrame(this,adminConnesso,token);
		homePageAdmin.setVisible(false);
		creaAgenteFrame.setVisible(true);
		
	}



	public void switchCreaAgenteFrameToHomePageAdmin() {
		creaAgenteFrame.setVisible(false);
		homePageAdmin.setVisible(true);
		
	}


	public void switchLoginFrameToSignUpFrame() {
		signUpFrame=new SignUpFrame(this);
		loginFrame.setVisible(false);
		signUpFrame.setVisible(true);
		
	}
	public void switchSignUpFrameToLoginFrame() {
		signUpFrame.setVisible(false);
		loginFrame.setVisible(true);
		
	}

	public void switchHomePageAdminToCreaAmministratoreFrame(Amministratore adminConnesso, String token) {
		creaAmministratoreFrame= new CreaAmministratoreFrame(this,adminConnesso,token);
		homePageAdmin.setVisible(false);
		creaAmministratoreFrame.setVisible(true);
			
	}


	public void switchCreaAmministratoreFrameToHomePageAdmin() {
		creaAmministratoreFrame.setVisible(false);
		homePageAdmin.setVisible(true);
	}



	public void switchHomePageAdminToModificaPasswordFrame(Amministratore adminConnesso, String token) {
		modificaPasswordFrame=new ModificaPasswordFrame(this,adminConnesso,token);
		homePageAdmin.setVisible(false);
		modificaPasswordFrame.setVisible(true);
		
		
	}



	public static String getBASE_URI() {
		return BASE_URI;
	}



	public void switchModificaPasswordFrameToHomePageAdmin() {
		modificaPasswordFrame.setVisible(false);
		homePageAdmin.setVisible(true);		
	}



	public void switchLoginToHomePageUtente(Utente utenteConnesso, String token) {
		homePageUtente= new HomePageUtenteFrame(this,utenteConnesso,token);
		loginFrame.setVisible(false);
		homePageUtente.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}

	public void switchLoginToHomePageAgente(Agente agenteConnesso, String token) {
		homePageAgente = new HomePageAgenteFrame(this, agenteConnesso, token);
		loginFrame.setVisible(false);
		homePageAgente.setVisible(true);
	}

	public void switchHomePageAdminToVisualizzaInserzioni(Starter starter, String token, List<Inserzione> inserzioni) {
		visualizzaInserzioni=new VisualizzaInserzioni(starter,token,inserzioni,homePageAdmin);
		homePageAdmin.setVisible(false);
		visualizzaInserzioni.setVisible(true);
	}



	public void switchVisualizzaInserzioniToHomePage(JFrame homePage) {
		visualizzaInserzioni.setVisible(false);
		homePage.setVisible(true);
	}



	public void switchVisualizzaInserzioniToModificaInserzione(Inserzione inserzione,JFrame homePage) {
		modificaInserzioneFrame=new ModificaInserzioneFrame(this,visualizzaInserzioni.getToken(),inserzione,homePage);
		visualizzaInserzioni.setVisible(false);
		modificaInserzioneFrame.setVisible(true);
		
	}
	public void switchModificaInserzioneToVisualizzaInserzioni() {
		modificaInserzioneFrame.setVisible(false);
		visualizzaInserzioni.setVisible(true);
		
		
	}



	public void switchModificaInserzioneToHomePage(JFrame homePage) {
		modificaInserzioneFrame.setVisible(false);
		homePage.setVisible(true);
		
	}



	public void switchHomePageAgenteToVisualizzaInserzioni(Starter starter, String token, List<Inserzione> inserzioni) {
	
		visualizzaInserzioni=new VisualizzaInserzioni(starter,token,inserzioni,homePageAgente);
		homePageAgente.setVisible(false);
		visualizzaInserzioni.setVisible(true);
	}



}
