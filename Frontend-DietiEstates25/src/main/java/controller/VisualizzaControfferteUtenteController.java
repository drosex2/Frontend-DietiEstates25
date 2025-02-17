package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import dto.Controfferta;
import dto.Offerta;
import gui.VisualizzaControfferteUtenteFrame;
import starter.Starter;

public class VisualizzaControfferteUtenteController {
	private VisualizzaControfferteUtenteFrame visualizzaControfferteUtenteFrame;
	
	public VisualizzaControfferteUtenteController(VisualizzaControfferteUtenteFrame visualizzaControfferteUtenteFrame) {
		this.visualizzaControfferteUtenteFrame=visualizzaControfferteUtenteFrame;
	}

	public void aggiornaEsito(Controfferta controfferta,String esito) {
		try {
			updateEsitoRequest(controfferta.getId(),esito);
			controfferta.setEsito(esito);
			visualizzaControfferteUtenteFrame.loadControfferteInAttesa();
			if(esito.equals("accettata")) {
				visualizzaControfferteUtenteFrame.showUpdateDialog("Controfferta accettata con successo");
			}else {
				visualizzaControfferteUtenteFrame.showUpdateDialog("Controfferta rifiutata con successo");
			}	
		}catch(Exception e) {
			visualizzaControfferteUtenteFrame.showUpdateDialog(e.getMessage());
		}
	}
	public void updateEsitoRequest(int id,String esito) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("controfferta/id/%d/esito/%s",id,esito);
		HttpRequest modificaEsitoRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+visualizzaControfferteUtenteFrame.getToken())
				.PUT(HttpRequest.BodyPublishers.ofString(""))
				.build();
		HttpResponse<String> modificaEsitoResponse;
		try {
			modificaEsitoResponse = client.send(modificaEsitoRequest, HttpResponse.BodyHandlers.ofString());
			if(modificaEsitoResponse.statusCode()!=201) {
				throw new Exception("Errore nell'aggiornamento dell'esito"+modificaEsitoResponse.statusCode());
			}
		} catch (IOException | InterruptedException e) {
			throw new Exception("Errore nell'aggiornamento dell'esito");
		}
		
	}
	
	
	
}
