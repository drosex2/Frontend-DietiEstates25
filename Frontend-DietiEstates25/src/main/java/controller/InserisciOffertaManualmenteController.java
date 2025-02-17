package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import dto.Inserzione;
import dto.Offerta;
import dto.Utente;
import gui.InserisciOffertaManualmenteFrame;
import starter.Starter;

public class InserisciOffertaManualmenteController {
	

	private InserisciOffertaManualmenteFrame inserisciOffertaManualmenteFrame;
	
	public InserisciOffertaManualmenteController(InserisciOffertaManualmenteFrame inserisciOffertaManualmenteFrame) {
		this.inserisciOffertaManualmenteFrame=inserisciOffertaManualmenteFrame;
	}

	public void inserisciOfferta(String email, Inserzione inserzione,int offerta) throws Exception {
		try {
			Utente utente=getUtente(email);
			saveOfferta(utente,inserzione,offerta);
		} catch (IOException | InterruptedException e) {
			throw new Exception("Non esiste nessun utente con l'email inserita");
		}
	}

	private void saveOfferta(Utente utente, Inserzione inserzione, int offerta) throws Exception {
		Offerta nuovaOfferta=new Offerta(0,offerta,"in attesa",utente,inserzione.getAgente(),inserzione);
		String json=new Gson().toJson(nuovaOfferta);
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest saveOffertaRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"offerta"))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+inserisciOffertaManualmenteFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		try {
			HttpResponse<String> saveOffertaResponse = client.send(saveOffertaRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			
			throw new Exception("Errore nel salvataggio dell'offerta");
		}
		
	}

	private Utente getUtente(String email) throws IOException, InterruptedException, Exception {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest getUtenteRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"utente/"+email))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+inserisciOffertaManualmenteFrame.getToken())
				.GET()
				.build();
		HttpResponse<String> getUtenteResponse = client.send(getUtenteRequest, HttpResponse.BodyHandlers.ofString());
		if(getUtenteResponse.statusCode()==200) {
			Utente utente=new Gson().fromJson(getUtenteResponse.body(),Utente.class);
			return utente;
		}else {
			throw new Exception("Non esiste nessun utente con l'email indicata");
		}
		
	} 
	
	
	
}
