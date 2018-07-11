package com.example.pdmsebasa.parcial3.api;

import com.example.pdmsebasa.parcial3.api.models.ProductoModel;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CuteCharmsAPI {

    String END_POINT="https://parcial-final-api.herokuapp.com/";

    @FormUrlEncoded
    @POST("auth/login")
    Call<String> getToken(@Field("nickname") String nickname, @Field("password")String pass);

    @GET("api/user/detail")
    Call<String> getUserRol(@Header("Authorization") String auth);

    @GET("api/products")
    Call<List<ProductoModel>> getAllProducts(@Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("api/user")
    Call<Void> registerUser(@Field("nickname")String nickname, @Field("password")String password, @Field("rol_type")String role);

}
