package typeAdapter;

import com.google.gson.*;

import dto.Notifica;
import dto.NotificaCorrelazione;
import dto.NotificaPromozionale;
import dto.NotificaVisita;

import java.lang.reflect.Type;


public class NotificaDeserializer implements JsonDeserializer<Notifica> {
    @Override
    public Notifica deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        

        if (jsonObject.has("correlazione")){
        	System.out.println("c'è");
        	return new Gson().fromJson(json, NotificaCorrelazione.class);
        }else if(jsonObject.has("visita")) {
        	return new Gson().fromJson(json, NotificaVisita.class);
        }else {
        	return new Gson().fromJson(json, NotificaPromozionale.class);
        }
    }
}

