package controller;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.Inserzione;
import gui.ModificaInserzioneFrame;
import starter.Starter;

public class ModificaInserzioneController {
	
	private ModificaInserzioneFrame modificaInserzioneFrame;

	public ModificaInserzioneController(ModificaInserzioneFrame modificaInserzioneFrame) {
		this.modificaInserzioneFrame=modificaInserzioneFrame;
	}
	public ArrayList<String> getComuni() throws IOException, InterruptedException{
		Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://axqvoqvbfjpaamphztgd.functions.supabase.co/comuni?onlyname=true"))
                .setHeader("Content-type", "application/json")
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ArrayList<String> comuni = gson.fromJson(response.body(), type);
		return comuni;
	}
	public void aggiornaInserzione(Inserzione inserzione) throws Exception {
		try {
			HttpResponse<String> response=modificaInserzioneRequest(inserzione);
			if(response.statusCode()!=201) {
				
				throw new Exception("Aggiornamento inserzione non riuscito");
			}
		}catch(IOException | InterruptedException ex) {
			throw new Exception("Aggiornamento inserzione non riuscito");
		}
		
	}
	private HttpResponse<String> modificaInserzioneRequest(Inserzione inserzione) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		String json=new Gson().toJson(inserzione);
		HttpRequest modificaInserzioneRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"inserzione"))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+modificaInserzioneFrame.getToken())
				.PUT(HttpRequest.BodyPublishers.ofString(json))
				.build();
		HttpResponse<String> modificaInserzioneResponse = client.send(modificaInserzioneRequest, HttpResponse.BodyHandlers.ofString());
		return modificaInserzioneResponse;
	}

}
