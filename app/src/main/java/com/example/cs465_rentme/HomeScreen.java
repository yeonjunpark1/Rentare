package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Button mapButton = findViewById(R.id.map_button);
        Button lendButton = findViewById(R.id.lend_button);
        mapButton.setOnClickListener(this);
        lendButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.map_button) intent = new Intent(HomeScreen.this, Map.class);
        else if (v.getId() == R.id.lend_button) intent = new Intent(HomeScreen.this, lend_list.class);
        startActivity(intent);
    }
}
