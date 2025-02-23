package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import dto.Utente;
import gui.SignUpFrame;
import starter.Starter;

public class SignUpController {
	private SignUpFrame signUpFrame;
	
	public SignUpController(SignUpFrame signUpFrame) {
		
	}

	public void signUp(String email, String nome, String cognome, String password) throws Exception {
		if(verificaCampi(email, nome, cognome, password)) {
			Utente utente=new Utente(nome,cognome,email,password);
			HttpResponse<String> signUpResponse=signUpRequest(utente);
			if(signUpResponse.statusCode()!=201) {
				throw new Exception("Impossibile effettuare la registrazione"+ signUpResponse.statusCode());
			}
		}else
		{
			throw new Exception("Compila tutti i campi");
		}
		
	}

	private HttpResponse<String> signUpRequest(Utente utente) throws IOException, InterruptedException {
		String json=new Gson().toJson(utente);
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest signUpRequest = HttpRequest.newBuilder()
				.uri(URI.create(Starter.getBASE_URI()+"utente"))
				.headers("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		HttpResponse<String> signUpResponse = client.send(signUpRequest, HttpResponse.BodyHandlers.ofString());
		return signUpResponse;
	
	}

	private boolean verificaCampi(String email, String nome, String cognome, String password) {
		return !email.isBlank()&&!nome.isBlank()&&!cognome.isBlank()&&!password.isBlank();
	}

	public SignUpFrame getSignUpFrame() {
		return signUpFrame;
	}

	public void setSignUpFrame(SignUpFrame signUpFrame) {
		this.signUpFrame = signUpFrame;
	}

}
