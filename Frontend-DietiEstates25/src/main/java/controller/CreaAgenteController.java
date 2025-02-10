package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import dto.Agente;
import gui.CreaAgenteFrame;
import starter.Starter;

public class CreaAgenteController {
	private CreaAgenteFrame creaAgenteFrame;

	public CreaAgenteController(CreaAgenteFrame creaAgenteFrame) {
		this.creaAgenteFrame=creaAgenteFrame;
	}

	public void creaAgente(String email, String nome, String cognome, String password) throws Exception {
		if(verificaCampi(email, nome, cognome, password)) {
			Agente agente=new Agente(nome,cognome,email,password,creaAgenteFrame.getAdminConnesso().getAgenzia());
			HttpResponse<String> creaAgenteResponse=creaAgenteRequest(agente);
			if(creaAgenteResponse.statusCode()!=201) {
				throw new Exception ("Errore nella creazione dell'agente");
			}
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}

	private HttpResponse<String> creaAgenteRequest(Agente agente) throws IOException, InterruptedException {
		String json=new Gson().toJson(agente);
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest creaAgenteRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"agente"))
				.headers("Content-type", "application/json")
				.headers("Authorization","Bearer "+creaAgenteFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		HttpResponse<String> creaAgenteResponse = client.send(creaAgenteRequest, HttpResponse.BodyHandlers.ofString());
		return creaAgenteResponse;
	}
		

	private boolean verificaCampi(String email, String nome, String cognome, String password) {
		return !email.isBlank()&&!nome.isBlank()&&!cognome.isBlank()&&!password.isBlank();
	}
	
	

}
