package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import dto.Controfferta;
import dto.Offerta;
import gui.VisualizzaOfferteAgenteFrame;
import starter.Starter;

public class VisualizzaOfferteAgenteController {
	private VisualizzaOfferteAgenteFrame visualizzaOfferteAgenteFrame;
	
	public VisualizzaOfferteAgenteController(VisualizzaOfferteAgenteFrame frame) {
		this.visualizzaOfferteAgenteFrame=frame;
	}
	
	
	public void aggiornaEsito(Offerta offerta,String esito) {
		try {
			updateEsitoRequest(offerta.getId(),esito);
			offerta.setEsito(esito);
			visualizzaOfferteAgenteFrame.loadOfferteInAttesa();
			if(esito.equals("accettata")) {
				visualizzaOfferteAgenteFrame.showUpdateDialog("Offerta accettata con successo");
			}else {
				visualizzaOfferteAgenteFrame.showUpdateDialog("Offerta rifiutata con successo");
			}	
		}catch(Exception e) {
			visualizzaOfferteAgenteFrame.showUpdateDialog(e.getMessage());
		}
	}
	public void updateEsitoRequest(int id,String esito) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("offerta/id/%d/esito/%s",id,esito);
		HttpRequest modificaEsitoRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+visualizzaOfferteAgenteFrame.getToken())
				.PUT(HttpRequest.BodyPublishers.ofString(""))
				.build();
		HttpResponse<String> modificaEsitoResponse;
		try {
			modificaEsitoResponse = client.send(modificaEsitoRequest, HttpResponse.BodyHandlers.ofString());
			if(modificaEsitoResponse.statusCode()!=200) {
			throw new Exception("Errore nell'aggiornamento dell'esito");
			}
		} catch (IOException | InterruptedException e) {
			throw new Exception("Errore nell'aggiornamento dell'esito");
		}
		
	}
	public void inserisciControfferta(Offerta offerta,int valore) throws Exception {
		updateEsitoRequest(offerta.getId(),"rifiutata");
		offerta.setEsito("rifiutata");
		visualizzaOfferteAgenteFrame.loadOfferteInAttesa();
		HttpClient client = HttpClient.newHttpClient();
		Controfferta controfferta=new Controfferta(0,valore,"in attesa",offerta.getUtente(),offerta.getAgente(),offerta.getInserzione());
		String json=new Gson().toJson(controfferta);
		HttpRequest inserisciControffertaRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"controfferta"))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+visualizzaOfferteAgenteFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		try {
			client.send(inserisciControffertaRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new Exception("Errore nell'inserimento della controfferta");
		}
		
	}
	

}
