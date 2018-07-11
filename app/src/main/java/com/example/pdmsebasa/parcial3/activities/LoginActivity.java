package com.example.pdmsebasa.parcial3.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.transition.Explode;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.api.CuteCharmsAPI;
import com.example.pdmsebasa.parcial3.api.deserializers.TokenDeserializer;
import com.example.pdmsebasa.parcial3.api.deserializers.UserDeserializer;
import com.example.pdmsebasa.parcial3.utils.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    AppCompatButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(null);
            getWindow().setAllowEnterTransitionOverlap(true);
        }
        setContentView(R.layout.login_activity);
        bindViews();
    }


    private void bindViews() {
        username = findViewById(R.id.input_nickname);
        password = findViewById(R.id.input_password);
        button = findViewById(R.id.btn_login);
        button.setOnClickListener(v -> onClickLogin());

        AppCompatButton registerbutton = findViewById(R.id.btn_register);
        registerbutton.setOnClickListener(v -> openRegisterActivity());
    }

    private void onClickLogin() {
        String user, pass;
        user = username.getText().toString();
        pass = password.getText().toString();
        if (user.equals("") || pass.equals("")) {
            Toast.makeText(this, R.string.text_empty_field_error, Toast.LENGTH_SHORT).show();
        } else {
            String encrypted = Util.sha1(pass);
            login(user, pass);
        }
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login(String user, String pass) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new TokenDeserializer())
                .create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CuteCharmsAPI.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.build();
        Call<String> call = retrofit.create(CuteCharmsAPI.class).getToken(user, pass);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {
                    saveToken(response.body());
                    getRol(response.body());
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_wrong_credentials_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getRol(String token) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new UserDeserializer())
                .create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CuteCharmsAPI.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.build();
        Call<String> call = retrofit.create(CuteCharmsAPI.class).getUserRol("Bearer " + token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {
                    System.out.println("RESPONSE "+response.toString());
                    boolean isAdmin;
                    if (response.body().equals("customer")){
                        isAdmin = false;
                    }else{
                        isAdmin = true;
                    }

                    SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(getString(R.string.key_admin), isAdmin);
                    editor.apply();

                    Intent intent;
                    if (isAdmin) {
                        intent = new Intent(LoginActivity.this, MainActivity.class);
                    } else {
                        intent = new Intent(LoginActivity.this, MainActivityUser.class);
                    }
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void saveToken(String token) {
        SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(getString(R.string.key_token), token);
        editor.apply();
    }
}