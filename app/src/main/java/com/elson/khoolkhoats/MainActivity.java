package com.elson.khoolkhoats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    private Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetch login componets by their IDs
        inputEmail = findViewById(R.id.logonemail);
        inputPassword = findViewById(R.id.logonpass);
        btnLogin = findViewById(R.id.loginbtn);
        btnregister = findViewById(R.id.regbtn);


        //Get shared preference for storage
        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);

        //Values to store on the shared preference
        String email = "emailKey";
        String password = "passwordKey";


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Collect email and password from  preference storage
                String authEmail = preferences.getString(email, "");
                String authPassword = preferences.getString(password, "");

                //Convert Editable text fields for email and password to Strings
                String mail = inputEmail.getText().toString();
                String pass = inputPassword.getText().toString();

                //Ensure email and passwords are filled and not empty
                if (TextUtils.isEmpty(mail)) {

                    Toast.makeText(getBaseContext(), "Enter email address!", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getBaseContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Authentication to check if user exists
                if (authEmail.equals(mail) && authPassword.equals(pass)) {

                    //Create key value pairs to send preference data to the settings screen
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", mail);
                    editor.putString("password", pass);
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "Correct Credentials", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Setting.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();


                }


            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });

    }
}