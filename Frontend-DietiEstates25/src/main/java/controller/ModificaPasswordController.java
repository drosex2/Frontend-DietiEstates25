package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;




import gui.ModificaPasswordFrame;
import starter.Starter;

public class ModificaPasswordController {
	private ModificaPasswordFrame modificaPasswordFrame;

	public ModificaPasswordController(ModificaPasswordFrame modificaPasswordFrame) {
		this.modificaPasswordFrame = modificaPasswordFrame;
	}

	public void modificaPassword(String nuovaPassword) throws Exception {
			try {
				HttpResponse<String> creaAgenteResponse=modificaPasswordRequest(modificaPasswordFrame.getAdminConnesso().getNomeAdmin(),nuovaPassword);
				if(creaAgenteResponse.statusCode()!=200) {
					throw new Exception ("Errore nella modifica della password");
				}
			}catch(Exception ex) {
				throw new Exception("Errore nella modifica della password");
			}
	}
			
		

	private HttpResponse<String> modificaPasswordRequest(String nomeAdmin,String nuovaPassword) throws IOException, InterruptedException {
			
		HttpClient client = HttpClient.newHttpClient();

		String bodyPublisher=String.format("nomeAdmin/{%s}/password/{%s}",nomeAdmin,nuovaPassword);
		HttpRequest modificaPasswordRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"amministratore/"))
				.headers("Content-type", "application/json")
				.headers("Authorization","Bearer "+modificaPasswordFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(bodyPublisher))
				.build();
		HttpResponse<String> modificaPasswordResponse = client.send(modificaPasswordRequest, HttpResponse.BodyHandlers.ofString());
		return modificaPasswordResponse;
	}
}
	

