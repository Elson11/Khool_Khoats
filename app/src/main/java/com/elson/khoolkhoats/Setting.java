package com.elson.khoolkhoats;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Setting extends AppCompatActivity {
    private RadioGroup groupColors;
    private RadioButton royalty;
    private RadioButton coolness;
    private RadioButton summer;
    private RadioButton dark;
    private RadioButton formal;
    Button select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select = (Button) findViewById(R.id.select);
        groupColors = (RadioGroup) findViewById(R.id.chooseColors);
        royalty = (RadioButton) findViewById(R.id.royalty);
        coolness = (RadioButton) findViewById(R.id.coolness);
        summer = (RadioButton) findViewById(R.id.summer);
        dark = (RadioButton) findViewById(R.id.dark);
        formal = (RadioButton) findViewById(R.id.formal);

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
                Toast.makeText(Setting.this, "Not working here", Toast.LENGTH_SHORT).show();
                Setting.setBackgroundColor(Color.parseColor("#000000"));
                break;
        }


        groupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if ((null == rb) || (checkedId <= -1)) {
                    return;
                }


                Toast.makeText(Setting.this, rb.getText(), Toast.LENGTH_SHORT).show();
                View Setting =  findViewById(R.id.bgsetting);

                String text = (String) rb.getText().toString();
                final Intent intent;
                System.out.println(text);
                if(rb.getText().equals("royalty")){

                    Setting.setBackgroundColor(Color.parseColor("#9575CD"));

                }

                else if(rb.getText().equals("coolness")){

                    Setting.setBackgroundColor(Color.parseColor("#2196F3"));

                }else if(rb.getText().equals("summer")){

                    Setting.setBackgroundColor(Color.parseColor("#FF5252"));

                }else if(rb.getText().equals("dark")){

                    Setting.setBackgroundColor(Color.parseColor("#E8EAF6"));

                }else if(rb.getText().equals("formal")){

                    Setting.setBackgroundColor(Color.parseColor("#E8EAF6"));

                }


                else {


                    Toast.makeText(Setting.this, "Try Selecting Color Again", Toast.LENGTH_SHORT).show();
                }




            }


        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Collect id fro background color and fetch preference
                View Setting =  findViewById(R.id.bgsetting);
                String color;
                SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();


                RadioButton rb = (RadioButton) groupColors.findViewById(groupColors.getCheckedRadioButtonId());
                String text = (String) rb.getText().toString();
                final Intent intent;
                if(rb.getText().equals("royalty")){

                    Setting.setBackgroundColor(Color.parseColor("#9575CD"));
                    color ="royalty";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(Setting, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar sSnackbar = Snackbar.make(Setting, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    sSnackbar.show();
                                    Intent intent = new Intent(Setting.this, Quote.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }

                else  if(rb.getText().equals("coolness")){

                    Setting.setBackgroundColor(Color.parseColor("#2196F3"));
                    color ="coolness";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(Setting, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(Setting, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(Setting.this, Quote.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }else if(rb.getText().equals("summer")){

                    Setting.setBackgroundColor(Color.parseColor("#FF5252"));
                    color ="summer";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(Setting, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(Setting, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(Setting.this, Quote.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }else if(rb.getText().equals("dark")){

                    Setting.setBackgroundColor(Color.parseColor("#727272"));
                    color ="dark";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(Setting, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(Setting, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(Setting.this, Quote.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }else if(rb.getText().equals("formal")) {

                    Setting.setBackgroundColor(Color.parseColor("#E8EAF6"));
                    color = "formal";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(Setting, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(Setting, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(Setting.this, Quote.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }


                else {


                    Toast.makeText(Setting.this, "Try Selecting Color Again", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


}