package com.example.pdmsebasa.parcial3.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CuteCharmsAPI {

    String END_POINT="https://parcial-final-api.herokuapp.com/";

    @FormUrlEncoded
    @POST("/auth/login")
    Call<String> getToken(@Field("nickname") String nickname, @Field("password")String pass);


}
