package com.example.pdmsebasa.parcial3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pdmsebasa.parcial3.R;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    AppCompatButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bindViews();
    }


    private void bindViews(){
        username=findViewById(R.id.input_nickname);
        password=findViewById(R.id.input_password);
        button=findViewById(R.id.btn_login);
        button.setOnClickListener(v->login());
    }

    private void login(){
        String user, pass;
        user=username.getText().toString();
        pass=password.getText().toString();
        if(user.equals("")||pass.equals("")){
            Toast.makeText(this, R.string.text_empty_field_error, Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
