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

import dto.Offerta;
import gui.HomePageUtenteFrame;
import starter.Starter;
public class HomePageUtenteController {
	private HomePageUtenteFrame homePageFrame;
	public HomePageUtenteController(HomePageUtenteFrame homePageFrame) {
		this.homePageFrame=homePageFrame;
	}
	
	public List<Offerta> ottieniOfferteUtente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("offerta/emailUtente/%s",email);
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
	public List<Controfferta> ottieniControfferteUtente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("controfferta/emailUtente/%s",email);
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
