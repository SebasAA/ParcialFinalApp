package com.example.pdmsebasa.parcial3.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.transition.Explode;
import android.view.Window;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.pdmsebasa.parcial3.R;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    AppCompatButton button;
    ScrollView scrollView;

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


    private void bindViews(){
        username=findViewById(R.id.input_email);
        password=findViewById(R.id.input_password);
        button=findViewById(R.id.btn_login);
        scrollView=findViewById(R.id.content_login);
        button.setOnClickListener(v->login());
    }

    private void login(){
        String user, pass;
        user=username.getText().toString();
        pass=password.getText().toString();
        if(user.equals("")||pass.equals("")){
            Snackbar.make(scrollView, "no", Snackbar.LENGTH_LONG);
        }else{
            Snackbar.make(scrollView, "hola", Snackbar.LENGTH_LONG);
        }
    }

}
