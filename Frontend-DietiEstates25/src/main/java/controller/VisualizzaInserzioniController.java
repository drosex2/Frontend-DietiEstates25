package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JFrame;
import dto.Inserzione;
import gui.VisualizzaInserzioni;
import starter.Starter;

public class VisualizzaInserzioniController {
	private VisualizzaInserzioni visualizzaInserzioni;

	public VisualizzaInserzioniController(VisualizzaInserzioni visualizzaInserzioniAgenzia) {
		this.visualizzaInserzioni = visualizzaInserzioniAgenzia;
	}

	public void eliminaInserzione(Inserzione inserzione) {
		try {
			HttpResponse<String> eliminaInserzioneResponse=eliminaInserzioneRequest(inserzione.getId());
			if(eliminaInserzioneResponse.statusCode()==200) {
				visualizzaInserzioni.getInserzioni().remove(inserzione);
				visualizzaInserzioni.loadInserzioni();
				visualizzaInserzioni.showDeleteDialog();
			}else {
				visualizzaInserzioni.showErrorDeleteDialog();
			}
			
		}catch(Exception e) {
			visualizzaInserzioni.showErrorDeleteDialog();
		}
	}

	private HttpResponse<String> eliminaInserzioneRequest(int id) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("inserzione/%d",id);
		HttpRequest eliminaInserzioneRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+visualizzaInserzioni.getToken())
				.DELETE()
				.build();
		HttpResponse<String> eliminaInserzioneResponse = client.send(eliminaInserzioneRequest, HttpResponse.BodyHandlers.ofString());
		return eliminaInserzioneResponse;
	}

	public void modificaInserzione(Inserzione inserzione,JFrame homePage) {
		visualizzaInserzioni.getStarter().switchVisualizzaInserzioniToModificaInserzione(inserzione,homePage);
		
	}

	public VisualizzaInserzioni getVisualizzaInserzioni() {
		return visualizzaInserzioni;
	}

	public void setVisualizzaInserzioni(VisualizzaInserzioni visualizzaInserzioni) {
		this.visualizzaInserzioni = visualizzaInserzioni;
	}
	
	
	
	

}
