package com.example.admin.zuluapp10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void GoToColors(View view) {
        Intent intent = new Intent(MainActivity.this, colours.class);
        startActivity(intent);


    }

    public void GoToFamily(View view) {
        Intent intent = new Intent(MainActivity.this, family.class);
        startActivity(intent);
    }

    public void GoToNumbers(View view) {
        Intent intent = new Intent(MainActivity.this, numbers.class);
        startActivity(intent);



    }
    public void GoToPhrases(View view) {
        Intent intent = new Intent(MainActivity.this, phrases.class);
        startActivity(intent);


    }}


