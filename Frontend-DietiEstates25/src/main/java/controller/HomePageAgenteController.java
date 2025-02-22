package controller;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.Controfferta;
import dto.Inserzione;
import dto.Offerta;
import gui.HomePageAgenteFrame;
import starter.Starter;

public class HomePageAgenteController {
	
private HomePageAgenteFrame homePageFrame;
	
	public HomePageAgenteController(HomePageAgenteFrame homePageFrame) {
		this.homePageFrame=homePageFrame;
	}

	public List<Inserzione> ottieniInserzioniAgente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("inserzione/emailAgente/%s",email);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+homePageFrame.getToken())
				.GET()
				.build();
		
			HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Inserzione> inserzioni;
			Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
			inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(),listType);
			return inserzioni;
		
	}
	public List<Offerta> ottieniOfferteAgente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("offerta/emailAgente/%s",email);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniOfferteRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+homePageFrame.getToken())
				.GET()
				.build();
		
			HttpResponse<String> ottieniOfferteResponse = client.send(ottieniOfferteRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Offerta> offerte;
			Type listType = new TypeToken<ArrayList<Offerta>>(){}.getType();
			offerte=new Gson().fromJson(ottieniOfferteResponse.body(),listType);
			return offerte;
		
	}
	public List<Controfferta> ottieniControfferteAgente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("controfferta/emailAgente/%s",email);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniControfferteRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+homePageFrame.getToken())
				.GET()
				.build();
		
			HttpResponse<String> ottieniControfferteResponse = client.send(ottieniControfferteRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Controfferta> inserzioni;
			Type listType = new TypeToken<ArrayList<Controfferta>>(){}.getType();
			inserzioni=new Gson().fromJson(ottieniControfferteResponse.body(),listType);
			return inserzioni;
		
	}

}
