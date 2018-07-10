package com.example.pdmsebasa.parcial3.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.example.pdmsebasa.parcial3.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;


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
        //username=findViewById();
        //password=findViewById();
    }

}
