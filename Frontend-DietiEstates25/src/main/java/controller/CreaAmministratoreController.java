package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import dto.Amministratore;
import gui.CreaAmministratoreFrame;
import starter.Starter;

public class CreaAmministratoreController {
	private CreaAmministratoreFrame creaAmministratoreFrame;
	
	public CreaAmministratoreController(CreaAmministratoreFrame creaAmministratoreFrame) {
		this.creaAmministratoreFrame=creaAmministratoreFrame;
	}

	public void creaAmministratore(String nomeAdmin,String password) throws Exception {
		if(verificaCampi(nomeAdmin, password)) {
			Amministratore amministratore=new Amministratore(nomeAdmin,password,creaAmministratoreFrame.getAdminConnesso().getAgenzia());
			HttpResponse<String> creaAdminResponse=creaAdminRequest(amministratore);
			if(creaAdminResponse.statusCode()!=201) {
				throw new Exception ("Errore nella creazione dell'amministratore ");
			}
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}

	private HttpResponse<String> creaAdminRequest(Amministratore admin) throws IOException, InterruptedException {
		String json=new Gson().toJson(admin);
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest creaAdminRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"amministratore"))
				.headers("Content-type", "application/json")
				.headers("Authorization","Bearer "+creaAmministratoreFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		HttpResponse<String> creaAdminResponse = client.send(creaAdminRequest, HttpResponse.BodyHandlers.ofString());
		return creaAdminResponse;
	}
	private boolean verificaCampi(String nomeAdmin, String password) {
		return !nomeAdmin.isBlank()&&!password.isBlank();
	}
}
