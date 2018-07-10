package com.example.pdmsebasa.parcial3.api.deserializers;

import com.example.pdmsebasa.parcial3.database.entities.Producto;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductDeserializer implements JsonDeserializer<List<Producto>> {
    @Override
    public List<Producto> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Producto> productos=new ArrayList<>();
        JsonArray array=json.getAsJsonArray();
        /*for(JsonElement x: array){
            JsonObject object=x.getAsJsonObject();

            productos.add(new Producto(
                    object.get("id").getAsString(),
                    object.get("name").getAsString(),
                    object.get("id_lista_materiales").getAsString(),
                    object.get
            ))}*/


        return null;
    }

}
