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
import gui.DettagliInserzioneFrame;
import starter.Starter;

public class DettagliInserzioneController {
	private DettagliInserzioneFrame dettagliInserzioneFrame;
	
	public DettagliInserzioneController(DettagliInserzioneFrame dettagliInserzioneFrame) {
		this.setDettagliInserzioneFrame(dettagliInserzioneFrame);
	}
	public void inserisciOfferta(Utente utente, Inserzione inserzione, int offerta) throws Exception {
		Offerta nuovaOfferta=new Offerta(0,offerta,"in attesa",utente,inserzione.getAgente(),inserzione);
		String json=new Gson().toJson(nuovaOfferta);
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest saveOffertaRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"offerta"))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+dettagliInserzioneFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		try {
			HttpResponse<String> saveOffertaResponse = client.send(saveOffertaRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			
			throw new Exception("Errore nel salvataggio dell'offerta");
		}
		
	}
	
	
	public DettagliInserzioneFrame getDettagliInserzioneFrame() {
		return dettagliInserzioneFrame;
	}

	public void setDettagliInserzioneFrame(DettagliInserzioneFrame dettagliInserzioneFrame) {
		this.dettagliInserzioneFrame = dettagliInserzioneFrame;
	}

}
