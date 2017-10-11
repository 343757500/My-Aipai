package mymap.my_aipai.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


/**
 * Created by Roger on 7/2/15.
 */
public class NewVideoInfoFormatter implements JsonDeserializer<NewVideoInfo>, JsonSerializer<NewVideoInfo> {

    @Override
    public NewVideoInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if (json.isJsonObject()) {
                JsonObject jsonObj = json.getAsJsonObject();
                NewVideoInfo newVideoInfo = new NewVideoInfo();
                String id = jsonObj.get("id").getAsString();
                String title = jsonObj.get("title").getAsString();
                String url = jsonObj.get("url").getAsString();
                if (id != null) {
                    newVideoInfo.setId(id);
                }
                if (title != null) {
                    newVideoInfo.setTitle(title);
                }
                if (url != null) {
                    newVideoInfo.setUrl(url);
                }
                return newVideoInfo;
            }
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public JsonElement serialize(NewVideoInfo src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.getAsJsonObject().add("id", new JsonPrimitive(src.getId()));
        jsonObject.getAsJsonObject().add("title", new JsonPrimitive(src.getTitle()));
        jsonObject.getAsJsonObject().add("url", new JsonPrimitive(src.getUrl()));
        return jsonObject;
    }
}
