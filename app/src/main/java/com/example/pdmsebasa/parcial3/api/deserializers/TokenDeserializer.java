package com.example.pdmsebasa.parcial3.api.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class TokenDeserializer implements JsonDeserializer<String>{
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String token="";
        JsonObject jsonObject=json.getAsJsonObject();
        if(jsonObject.has("token")){
            token=jsonObject.get("token").getAsString();
        }
        return token;
    }
}
