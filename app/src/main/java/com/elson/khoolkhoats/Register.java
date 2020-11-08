package com.elson.khoolkhoats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.Button;

public class Register extends AppCompatActivity {

    private EditText inputEmail, inputPassword, inputName, inpuSurname;
    private Button btnregister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Fetch login componets by their IDs
        inputEmail = findViewById(R.id.logonemail);
        inputPassword = findViewById(R.id.logonpass);
        inputName = findViewById(R.id.name);
        inpuSurname = findViewById(R.id.surname);
        btnregister2 = findViewById(R.id.regbtn2);

        //Get shared preference for storage
        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);

        //Values to store on the shared preference
        String email = "emailKey";
        String password = "passwordKey";
        String name = "nameKey";
        String surname = "surnameKey";


        btnregister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Store user email and password to preference
                String e = inputEmail.getText().toString();
                String p = inputPassword.getText().toString();
                String n = inputName.getText().toString();
                String s = inpuSurname.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(email, e);
                editor.putString(password, p);
                editor.putString(name, n);
                editor.putString(surname, n);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);


            }
        });

        /*btnregister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Store user email and password to preference
                String e = inputEmail.getText().toString();
                String p = inputPassword.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(email, e);
                editor.putString(password, p);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                inputEmail.setText("");
                inputPassword.setText("");

            }
        });*/

    }
}