package com.example.pdmsebasa.parcial3.api;

import android.content.Context;

import com.example.pdmsebasa.parcial3.api.deserializers.UserDeserializer;
import com.example.pdmsebasa.parcial3.api.models.MaterialModel;
import com.example.pdmsebasa.parcial3.api.models.ProductoModel;
import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;
import com.example.pdmsebasa.parcial3.database.entities.Material;
import com.example.pdmsebasa.parcial3.database.entities.Producto;
import com.example.pdmsebasa.parcial3.database.viewmodel.ViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRequest {

    private static CuteCharmsAPI getClient(Gson gson){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CuteCharmsAPI.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.build();
        return retrofit.create(CuteCharmsAPI.class);
    }

    public static void getAllProducts(ViewModel viewModel, Context context, String token){
        Call<List<ProductoModel>> call=getClient(new Gson())
                .getAllProducts("Bearer "+token);
        call.enqueue(new Callback<List<ProductoModel>>() {
            @Override
            public void onResponse(Call<List<ProductoModel>> call, Response<List<ProductoModel>> response) {
                if(response.code()==200){
                    for(ProductoModel x:response.body()){
                        for(MaterialModel y:x.getProductMaterials()){
                            viewModel.insert(new ListaMateriales(x.getId(),y.getIdMaterial(),y.getCantidad()));
                        }
                        viewModel.insert(new Producto(x.getId(), x.getName(), x.getCost(),x.getPrice(),x.getStock(),x.getSold(),x.getCategory(),x.getProductImage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProductoModel>> call, Throwable t) {
                    t.printStackTrace();
            }
        });
    }


}
