package com.example.pdmsebasa.parcial3.activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pdmsebasa.parcial3.R;

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(this::startActivity, 3000);
    }

    private void startActivity(){
        Intent intent;
        if (getToken().equals("")){
            intent = new Intent(this, LoginActivity.class);
        }else{
            if (isAdmin()){
                intent = new Intent(this, MainActivity.class);
            }else{
                intent = new Intent(this, MainActivityUser.class);
            }
        }
        startActivity(intent);
        finish();
    }

    private String getToken(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(getString(R.string.key_token), "");
    }

    private Boolean isAdmin(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("ADMIN", false);
    }
}
