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
import gui.InserisciInserzioneFrame;
import starter.Starter;

public class InserisciInserzioneController {
	private InserisciInserzioneFrame inserisciInserzioneFrame;
	
	public InserisciInserzioneController(InserisciInserzioneFrame frame) {
		this.setInserisciInserzioneFrame(frame);
	}

	public InserisciInserzioneFrame getInserisciInserzioneFrame() {
		return inserisciInserzioneFrame;
	}

	public void setInserisciInserzioneFrame(InserisciInserzioneFrame inserisciInserzioneFrame) {
		this.inserisciInserzioneFrame = inserisciInserzioneFrame;
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

	public void inserisciInserzione(Inserzione inserzione) throws Exception {
		try {
			HttpResponse<String> response=inserisciInserzioneRequest(inserzione);
			if(response.statusCode()!=201) {
				
				throw new Exception("Inserimento inserzione non riuscito");
			}
		}catch(IOException | InterruptedException ex) {
			throw new Exception("Inserimento inserzione non riuscito");
		}
		
	}

	private HttpResponse<String> inserisciInserzioneRequest(Inserzione inserzione) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		String json=new Gson().toJson(inserzione);
		HttpRequest inserisciInserzioneRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"inserzione"))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+inserisciInserzioneFrame.getToken())
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		HttpResponse<String> inserisciInserzioneResponse = client.send(inserisciInserzioneRequest, HttpResponse.BodyHandlers.ofString());
		return inserisciInserzioneResponse;
	}
}
