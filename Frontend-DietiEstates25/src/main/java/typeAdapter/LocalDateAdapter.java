package typeAdapter;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), FORMATTER);
    }

    @Override
    public JsonElement serialize(LocalDate localDate, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(localDate.format(FORMATTER));
    }
}
