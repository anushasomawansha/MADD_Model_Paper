package com.example.model_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    EditText username,password;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username=findViewById(R.id.etUsernameH);
        password=findViewById(R.id.etPasswordH);
        login=findViewById(R.id.btnLoginH);
        register=findViewById(R.id.btnRegisterH);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,ProfileManagement.class);
                startActivity(intent);
            }
        });


    }
}