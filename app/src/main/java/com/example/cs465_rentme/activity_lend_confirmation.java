package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_lend_confirmation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_confirmation);

        Button rent_home_button1 = findViewById(R.id.rent_home_button1);
        rent_home_button1.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.rent_home_button1) intent = new Intent(activity_lend_confirmation.this, HomeScreen.class);
        startActivity(intent);
    }
}
