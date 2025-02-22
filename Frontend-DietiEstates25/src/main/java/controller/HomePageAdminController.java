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
import gui.HomePageAdminFrame;
import starter.Starter;

public class HomePageAdminController {
	private HomePageAdminFrame homePageFrame;
	
	public HomePageAdminController(HomePageAdminFrame homePageFrame) {
		this.homePageFrame=homePageFrame;
	}
	public ArrayList<Inserzione> ottieniInserzioniAgenzia(String nomeAgenzia) throws IOException, InterruptedException{
		
		HttpClient client = HttpClient.newHttpClient();
		String url=String.format("inserzione/agenzia/%s",nomeAgenzia);
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
}
