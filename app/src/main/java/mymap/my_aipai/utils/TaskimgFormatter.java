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
 * Created by leo on 29/6/15.
 */
public class TaskimgFormatter implements JsonDeserializer<TaskImage>, JsonSerializer<TaskImage> {
    @Override
    public TaskImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonObject()) {
            JsonObject jsonObj = json.getAsJsonObject();
            TaskImage info = new TaskImage();
            String url = jsonObj.get("url").getAsString();
            String endTime = jsonObj.get("endTime").getAsString();
            String img = jsonObj.get("img").getAsString();
            int status = jsonObj.get("status").getAsInt();
            int notice = jsonObj.get("notice").getAsInt();
            if (url != null) {
                info.setUrl(url);
            }
            if (endTime != null) {
                info.setEndTime(endTime);
            }
            if (img != null) {
                info.setImg(img);
            }
            info.setStatus(status);
            info.setNotice(notice);
            return info;
        }
        return null;
    }

    @Override
    public JsonElement serialize(TaskImage src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.getAsJsonObject().add("url", new JsonPrimitive(src.getUrl()));
        jsonObject.getAsJsonObject().add("endTime", new JsonPrimitive(src.getEndTime()));
        jsonObject.getAsJsonObject().add("img", new JsonPrimitive(src.getImg()));
        jsonObject.getAsJsonObject().add("status", new JsonPrimitive(src.getStatus()));
        jsonObject.getAsJsonObject().add("notice", new JsonPrimitive(src.getNotice()));
        return jsonObject;
    }
}
