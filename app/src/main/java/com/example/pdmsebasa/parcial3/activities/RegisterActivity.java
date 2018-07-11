package com.example.pdmsebasa.parcial3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.api.CuteCharmsAPI;
import com.example.pdmsebasa.parcial3.utils.Util;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        EditText nicknameEditText = findViewById(R.id.input_rnickname);
        EditText passwordEditText = findViewById(R.id.input_rpassword);
        EditText confirmEditText = findViewById(R.id.conf_password);
        AppCompatButton registerButton = findViewById(R.id.btn_register);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nickname = nicknameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirm = confirmEditText.getText().toString();

                if (nickname.equals("") || password.equals("") || confirm.equals("")){
                    Toast.makeText(getApplicationContext(), getString(R.string.text_empty_field_error), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirm)){
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                String encrypted = Util.sha1(password);
                registerUser(nickname, password);
            }
        });
    }

    private void registerUser(String nickname, String password){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CuteCharmsAPI.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(new Gson()));
        Retrofit retrofit = builder.build();
        String role = "customer";
        Call<Void> registerUser = retrofit.create(CuteCharmsAPI.class).registerUser(nickname, password, role);
        registerUser.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
