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
public class TaskTextFormatter implements JsonDeserializer<TaskText>, JsonSerializer<TaskText> {

    @Override
    public TaskText deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonObject()) {
            JsonObject jsonObj = json.getAsJsonObject();
            TaskText info = new TaskText();
            String color = jsonObj.get("bgColor").getAsString();
            String title = jsonObj.get("title").getAsString();
            String url = jsonObj.get("url").getAsString();
            String userCount = jsonObj.get("userCount").getAsString();
            String goldCount = jsonObj.get("goldCount").getAsString();
            String endTime = jsonObj.get("endTime").getAsString();
            int status = jsonObj.get("status").getAsInt();
            int notice = jsonObj.get("notice").getAsInt();
            if (color != null) {
                info.setBgColor(color);
            }
            if (title != null) {
                info.setTitle(title);
            }
            if (url != null) {
                info.setUrl(url);
            }
            if (userCount != null) {
                info.setUserCount(userCount);
            }
            if (goldCount != null) {
                info.setGoldCount(goldCount);
            }
            if (endTime != null) {
                info.setEndTime(endTime);
            }
            info.setStatus(status);
            info.setNotice(notice);
            return info;
        }
        return null;
    }

    @Override
    public JsonElement serialize(TaskText src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.getAsJsonObject().add("bgColor", new JsonPrimitive(src.getBgColor()));
        jsonObject.getAsJsonObject().add("title", new JsonPrimitive(src.getTitle()));
        jsonObject.getAsJsonObject().add("url", new JsonPrimitive(src.getUrl()));
        jsonObject.getAsJsonObject().add("userCount", new JsonPrimitive(src.getUserCount()));
        jsonObject.getAsJsonObject().add("goldCount", new JsonPrimitive(src.getGoldCount()));
        jsonObject.getAsJsonObject().add("endTime", new JsonPrimitive(src.getEndTime()));
        jsonObject.getAsJsonObject().add("status", new JsonPrimitive(src.getStatus()));
        jsonObject.getAsJsonObject().add("notice", new JsonPrimitive(src.getNotice()));
        return jsonObject;
    }
}
