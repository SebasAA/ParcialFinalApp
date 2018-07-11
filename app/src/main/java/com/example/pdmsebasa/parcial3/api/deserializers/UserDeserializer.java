package com.example.pdmsebasa.parcial3.api.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<String>{
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object=json.getAsJsonObject();
        String rol="";
        if(object.has("rol_type")){
            rol=object.get("rol_type").getAsString();
        }
        return rol;
    }
}
