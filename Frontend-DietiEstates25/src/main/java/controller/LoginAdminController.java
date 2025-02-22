package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import gui.LoginAdminFrame;
import starter.Starter;

public class LoginAdminController {
	private LoginAdminFrame loginAdminFrame;
	
	public LoginAdminController(LoginAdminFrame loginAdminFrame) {
		this.loginAdminFrame=loginAdminFrame;
	}
	
	public String login(String nomeAdmin, String password) throws Exception{
		try {
			if(!nomeAdmin.isBlank() && !password.isBlank()) {
				HttpResponse<String> loginResponse = loginRequest(nomeAdmin, password);
				if(loginResponse.statusCode()==200) {
					return loginResponse.body();
				}else {
					throw new Exception("NomeAdmin e/o password errati");
				}
			}else
			{
				throw new Exception("Compilare i campi");
			}
		}catch(IOException | InterruptedException e) {
			 throw new Exception("Impossibile connettersi al server.");
		}
	}


	private HttpResponse<String> loginRequest(String nomeAdmin, String password)
			throws IOException, InterruptedException {
		String bodyPublisher=String.format("{\"nomeAdmin\":\"%s\", \"password\":\"%s\"}",nomeAdmin,password);
		String BASE_URI=Starter.getBASE_URI();
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest loginRequest = HttpRequest.newBuilder()
				.uri(URI.create(BASE_URI+"auth/admin"))
				.headers("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(bodyPublisher))
				.build();
		HttpResponse<String> loginResponse = client.send(loginRequest, HttpResponse.BodyHandlers.ofString());
		return loginResponse;
	}
	
}
