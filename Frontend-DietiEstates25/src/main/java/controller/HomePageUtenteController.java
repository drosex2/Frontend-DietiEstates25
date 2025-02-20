package controller;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import dto.Controfferta;
import dto.Notifica;
import dto.NotificaCorrelazione;
import dto.NotificaPromozionale;
import dto.NotificaVisita;
import dto.Offerta;
import dto.Ricerca;
import gui.HomePageUtenteFrame;
import starter.Starter;

import typeAdapter.*;
public class HomePageUtenteController {
	private HomePageUtenteFrame homePageFrame;
	public HomePageUtenteController(HomePageUtenteFrame homePageFrame) {
		this.homePageFrame=homePageFrame;
	}
	public List<Ricerca> ottieniRicercheUtente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("ricerca/utente/%s",email);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniRicercheRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+homePageFrame.getToken())
				.GET()
				.build();
		
			HttpResponse<String> ottieniRicercheResponse = client.send(ottieniRicercheRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Ricerca> ricerche;
			Type listType = new TypeToken<ArrayList<Ricerca>>(){}.getType();
			ricerche=new Gson().fromJson(ottieniRicercheResponse.body(),listType);
			return ricerche;		
	}
	
	public List<Notifica> ottieniNotificheUtente(String email) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("notifica/emailUtente/%s",email);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniNotificheRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+homePageFrame.getToken())
				.GET()
				.build();
		
			HttpResponse<String> ottieniNotificheResponse = client.send(ottieniNotificheRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Notifica> notifiche= new ArrayList<Notifica>();
			
			Gson gson = new GsonBuilder()
				    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
				    .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
				    .create();

			JsonArray jsonArray = JsonParser.parseString(ottieniNotificheResponse.body()).getAsJsonArray();

	        return deserializeNotifiche(notifiche, gson, jsonArray);		
	}
	public List<Notifica> deserializeNotifiche(ArrayList<Notifica> notifiche, Gson gson, JsonArray jsonArray) {
		for (JsonElement element : jsonArray) {
		    JsonObject jsonObject=element.getAsJsonObject();
		    Notifica notifica;
		    if (jsonObject.has("correlazione")){
		    	notifica= gson.fromJson(jsonObject, NotificaCorrelazione.class);
		    }else if(jsonObject.has("visita")) {
		    	notifica= gson.fromJson(jsonObject, NotificaVisita.class);
		    }else {
		    	notifica=gson.fromJson(jsonObject, NotificaPromozionale.class);
		    }
		    notifiche.add(notifica);
		}
		return notifiche;
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
