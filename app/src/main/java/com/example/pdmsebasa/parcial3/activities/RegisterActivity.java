package com.example.pdmsebasa.parcial3.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.utils.Util;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        EditText nicknameEditText = findViewById(R.id.input_rnickname);
        EditText passwordEditText = findViewById(R.id.input_rpassword);
        EditText confirmEditText = findViewById(R.id.conf_password);
        Button registerButton = findViewById(R.id.btn_register);

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
                    Toast.makeText(getApplicationContext(), R.string.text_password_match_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                registerUser(nickname, Util.sha1(password));
            }
        });
    }

    private void registerUser(String nickname, String password){

    }
}
