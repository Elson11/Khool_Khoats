package com.elson.khoolkhoats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Quote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        View Setting =  findViewById(R.id.bgsetting);



        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        String maincolour = preferences.getString("colour", "dark");


        switch (maincolour) {
            case "royalty":
                Setting.setBackgroundColor(Color.parseColor("#9575CD"));
                break;
            case "coolness":
                Setting.setBackgroundColor(Color.parseColor("#2196F3"));


                break;
            case "summer":
                Setting.setBackgroundColor(Color.parseColor("#FF5252"));


                break;
            case "dark":
                Setting.setBackgroundColor(Color.parseColor("#727272"));


                break;
            case "formal":
                Setting.setBackgroundColor(Color.parseColor("#E8EAF6"));


                break;
            default:
                Toast.makeText(Quote.this, "Not working here", Toast.LENGTH_SHORT).show();
                Setting.setBackgroundColor(Color.parseColor("#000000"));
                break;
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainsettings:
                Intent intent = new Intent(this, Setting.class);
                startActivity(intent);
                return true;
            case R.id.help:
                Toast.makeText(this,"Help Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact:
                Toast.makeText(this,"Contact Us Selected",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return  super.onOptionsItemSelected(item);





        }
    }
}