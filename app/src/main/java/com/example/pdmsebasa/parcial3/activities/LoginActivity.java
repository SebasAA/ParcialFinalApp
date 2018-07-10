package com.example.pdmsebasa.parcial3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;

import com.example.pdmsebasa.parcial3.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;
    AppCompatButton button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bindViews();
    }


    private void bindViews(){
        username=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        button=findViewById(R.id.btn_login);
        button.setOnClickListener(v->login());
    }

    private void login(){
        String user, pass;
        user=username.getText().toString();
        pass=password.getText().toString();
        if(user.equals("")&&pass.equals("")){
            //Snackbar.make()
        }else{

        }
    }


}
