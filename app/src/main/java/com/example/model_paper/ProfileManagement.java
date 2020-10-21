package com.example.model_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.model_paper.DataBase.DBHandler;

public class ProfileManagement extends AppCompatActivity {
    EditText username,dob,password;
    Button add,update;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username=findViewById(R.id.etUserNamePM);
        dob=findViewById(R.id.etDob);
        password=findViewById(R.id.etPasswordPM);
        male=findViewById(R.id.radioBtnMalePM);
        female=findViewById(R.id.radioBtnFemalePM);
        add=findViewById(R.id.btnAdd);
        update=findViewById(R.id.btnUpdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileManagement.this,EditeProfile.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newId=dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User added. User Id:"+newId, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ProfileManagement.this,EditeProfile.class);
                startActivity(intent);

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(false);
                female.setChecked(false);

            }
        });
    }
}