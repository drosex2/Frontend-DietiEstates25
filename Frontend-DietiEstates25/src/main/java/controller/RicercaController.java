package controller;

import dto.Ricerca;
import starter.Starter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Inserzione;

public class RicercaController {
	private String token;
	public RicercaController(String token) {
		this.token=token;
	}
	public LinkedList<String> getComuni() throws IOException, InterruptedException{
		Gson gson = new Gson();
        Type type = new TypeToken<LinkedList<String>>() {
        }.getType();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://axqvoqvbfjpaamphztgd.functions.supabase.co/comuni?onlyname=true"))
                .setHeader("Content-type", "application/json")
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        LinkedList<String> comuni = gson.fromJson(response.body(), type);
		return comuni;
	}
	public List<Inserzione> eseguiRicerca(Ricerca ricerca) throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();
		
		String url=String.format("inserzione/ricerca");
		String json=new Gson().toJson(ricerca);
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization","Bearer "+token)
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		
			HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest, HttpResponse.BodyHandlers.ofString());
			ArrayList<Inserzione> inserzioni;
			Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
			inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(),listType);
			return inserzioni;
		
	}
	public List<Inserzione> getByRangePrezzo(int minimo,int massimo) throws IOException, InterruptedException{
		HttpClient client=HttpClient.newHttpClient();
		String url=String.format("inserzione/prezzoMinimo/%d/prezzoMassimo/%d",minimo,massimo);
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+token)
				.GET()
				.build();
		HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest,HttpResponse.BodyHandlers.ofString());
		ArrayList <Inserzione> inserzioni;
		Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
		inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(), listType);
		return inserzioni;
	}
	public List<Inserzione> getByNumeroStanze(int numeroStanze) throws IOException, InterruptedException{
		HttpClient client=HttpClient.newHttpClient();
		String url=String.format("inserzione/numeroStanze/%d",numeroStanze);
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+token)
				.GET()
				.build();
		HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest,HttpResponse.BodyHandlers.ofString());
		ArrayList <Inserzione> inserzioni;
		Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
		inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(), listType);
		return inserzioni;
	}
	
	public List<Inserzione> getByClasseEnergetica(String classeEnergetica) throws IOException, InterruptedException{
		HttpClient client=HttpClient.newHttpClient();
		String url=String.format("inserzione/classeEnergetica/%s",classeEnergetica);
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+token)
				.GET()
				.build();
		HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest,HttpResponse.BodyHandlers.ofString());
		ArrayList <Inserzione> inserzioni;
		Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
		inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(), listType);
		return inserzioni;
	}
	public List<Inserzione> getByCitta(String citta) throws IOException, InterruptedException{
		HttpClient client=HttpClient.newHttpClient();
		String url=String.format("inserzione/citta/%s",citta);
		String urlFormatted=url.replace(" ", "%20");
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+urlFormatted))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+token)
				.GET()
				.build();
		HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest,HttpResponse.BodyHandlers.ofString());
		ArrayList <Inserzione> inserzioni;
		Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
		inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(), listType);
		return inserzioni;
	}
	public List<Inserzione> getByRaggio(double latitudine,double longitudine,int raggio) throws IOException, InterruptedException{
		
		HttpClient client=HttpClient.newHttpClient();
		String url=String.format("inserzione/latitudine/%f/longitudine/%f/raggio/%d",latitudine,longitudine,raggio);
		url=url.replace(',', '.');
		HttpRequest ottieniInserzioniRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+url))
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer "+token)
				.GET()
				.build();
		HttpResponse<String> ottieniInserzioniResponse = client.send(ottieniInserzioniRequest,HttpResponse.BodyHandlers.ofString());
		ArrayList <Inserzione> inserzioni;
		Type listType = new TypeToken<ArrayList<Inserzione>>(){}.getType();
		inserzioni=new Gson().fromJson(ottieniInserzioniResponse.body(), listType);
		
		return inserzioni;
	}

}
