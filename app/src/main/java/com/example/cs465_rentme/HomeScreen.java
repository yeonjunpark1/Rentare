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
        Button rentButton = findViewById(R.id.rent_button);
        Button settingsButton = findViewById(R.id.settings_button);
        mapButton.setOnClickListener(this);
        lendButton.setOnClickListener(this);
        rentButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.map_button) intent = new Intent(HomeScreen.this, Map.class);
        else if (v.getId() == R.id.lend_button) intent = new Intent(HomeScreen.this, lend_list.class);
        else if (v.getId() == R.id.rent_button) intent = new Intent(HomeScreen.this, rent_list.class);
        else if (v.getId() == R.id.settings_button) intent = new Intent(HomeScreen.this, user_page.class);
        startActivity(intent);
    }
}
