package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_lend_confirmation extends AppCompatActivity implements View.OnClickListener {
    String item_name;
    String item_price;
    String photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_confirmation);

        Intent intent = getIntent();
        item_name = intent.getStringExtra("item_name");
        item_price = intent.getStringExtra("item_price");
        photo = intent.getStringExtra("photo");

        Button rent_home_button1 = findViewById(R.id.rent_home_button1);
        rent_home_button1.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.rent_home_button1) {
            intent = new Intent(activity_lend_confirmation.this, lend_list.class);
            intent.putExtra("photo", photo);
            intent.putExtra("item_name", item_name);
            intent.putExtra("item_price", item_price);
            startActivity(intent);
        }
    }
}
