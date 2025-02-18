package typeAdapter;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter implements JsonDeserializer<LocalTime>, JsonSerializer<LocalTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;

    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalTime.parse(json.getAsString(), FORMATTER);
    }

    @Override
    public JsonElement serialize(LocalTime localTime, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(localTime.format(FORMATTER));
    }
}
