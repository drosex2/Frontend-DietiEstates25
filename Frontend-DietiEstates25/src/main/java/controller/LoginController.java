package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import gui.LoginFrame;
import starter.Starter;

public class LoginController {
    private LoginFrame loginFrame;

    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public String loginAgente(String email, String password) throws Exception {
    	try {
	    	if (!email.isBlank() && !password.isBlank()) {
	            HttpResponse<String> loginResponse = loginAgenteRequest(email, password);
	            if (loginResponse.statusCode()==200) {
	                return loginResponse.body();
	            } else {
	            	throw new Exception("E-mail e/o password errati");
	            }
	        } else {
	            throw new Exception("Compilare i campi");
	        }
    	}catch(IOException | InterruptedException e) {
    		 throw new Exception("Impossibile connettersi al server.");
    	}
    }
    
    public String loginUtente(String email, String password) throws Exception {
        try {
	    	if (!email.isBlank() && !password.isBlank()) {
	            HttpResponse<String> loginResponse = loginUtenteRequest(email, password);
	            if (loginResponse.statusCode() == 200) {
	                return loginResponse.body();
	            } else {
	                throw new Exception("E-mail e/o password errati");
	            }
	        } else {
	            throw new Exception("Compilare i campi");
	        }
	    }catch(IOException | InterruptedException e) {
			 throw new Exception("Impossibile connettersi al server.");
		}
    }

    private HttpResponse<String> loginUtenteRequest(String email, String password) 
            throws IOException, InterruptedException {
        String bodyPublisher = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);
        String BASE_URI = Starter.getBASE_URI();
        HttpClient client = HttpClient.newHttpClient();
        

        HttpRequest loginRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "auth/utente"))
                .headers("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyPublisher))
                .build();

        HttpResponse<String> loginResponse = client.send(loginRequest, HttpResponse.BodyHandlers.ofString());
        return loginResponse;
    }
    
    private HttpResponse<String> loginAgenteRequest(String email, String password) 
            throws IOException, InterruptedException {
        String bodyPublisher = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);
        String BASE_URI = Starter.getBASE_URI();
        HttpClient client = HttpClient.newHttpClient();
    
        HttpRequest loginRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "auth/agente"))
                .headers("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyPublisher))
                .build();

        HttpResponse<String> loginResponse = client.send(loginRequest, HttpResponse.BodyHandlers.ofString());
        return loginResponse;
    }
}
