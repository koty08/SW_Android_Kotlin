package com.example.week13ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fashionBtn = findViewById(R.id.fashionBtn);
        fashionBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FashionActivity.class);
            startActivity(i);
        });
    }
}