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

    public String loginUtente(String email, String password) throws Exception {
        if (!email.isBlank() && !password.isBlank()) {
            HttpResponse<String> loginResponse = loginRequest(email, password);
            if (loginResponse.statusCode() == 200) {
                return loginResponse.body();
            } else {
            	System.out.println("Status Code: " + loginResponse.statusCode());
            	System.out.println("Response Body: " + loginResponse.body());
                throw new Exception("NomeUtente e/o password errati");
            }
        } else {
            throw new Exception("Compilare i campi");
        }
    }

    private HttpResponse<String> loginRequest(String email, String password) 
            throws IOException, InterruptedException {
        String bodyPublisher = String.format("{\"emailUtente\":\"%s\", \"password\":\"%s\"}", email, password);
        String BASE_URI = Starter.getBASE_URI();
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("Email: " + email);  // Verifica l'email
        System.out.println("Password: " + password);  // Verifica la password

        HttpRequest loginRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "auth/utente"))
                .headers("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        HttpResponse<String> loginResponse = client.send(loginRequest, HttpResponse.BodyHandlers.ofString());
        return loginResponse;
    }
}
