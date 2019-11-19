package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RentPageOne extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_page_one);

        Button rent_page_one_button = findViewById(R.id.rent_page_one_button);
        rent_page_one_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(RentPageOne.this, rent_page_two.class);
        startActivity(intent);
    }
}
