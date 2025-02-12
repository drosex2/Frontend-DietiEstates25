package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import dto.Inserzione;
import gui.VisualizzaInserzioniAgenzia;
import starter.Starter;

public class VisualizzaInserzioniController {
	private VisualizzaInserzioniAgenzia visualizzaInserzioniAgenzia;

	public VisualizzaInserzioniController(VisualizzaInserzioniAgenzia visualizzaInserzioniAgenzia) {
		this.visualizzaInserzioniAgenzia = visualizzaInserzioniAgenzia;
	}

	public void eliminaInserzione(Inserzione inserzione) {
		try {
			HttpResponse<String> eliminaInserzioneResponse=eliminaInserzioneRequest(inserzione.getId());
			if(eliminaInserzioneResponse.statusCode()==200) {
				visualizzaInserzioniAgenzia.getInserzioni().remove(inserzione);
				visualizzaInserzioniAgenzia.loadInserzioni();
				visualizzaInserzioniAgenzia.showDeleteDialog();
			}else {
				visualizzaInserzioniAgenzia.showErrorDeleteDialog();
			}
			
		}catch(Exception e) {
			visualizzaInserzioniAgenzia.showErrorDeleteDialog();
		}
	}

	private HttpResponse<String> eliminaInserzioneRequest(int id) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("inserzione/%d",id);
		HttpRequest eliminaInserzioneRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+visualizzaInserzioniAgenzia.getToken())
				.DELETE()
				.build();
		HttpResponse<String> eliminaInserzioneResponse = client.send(eliminaInserzioneRequest, HttpResponse.BodyHandlers.ofString());
		return eliminaInserzioneResponse;
	}
	
	
	
	

}
