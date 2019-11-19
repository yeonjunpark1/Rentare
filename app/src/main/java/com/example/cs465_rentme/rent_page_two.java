package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rent_page_two extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_page_two);

        Button rent_page_two_button = findViewById(R.id.reserve_button);
        rent_page_two_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(rent_page_two.this, rent_confirmation.class);
        startActivity(intent);
    }
}
