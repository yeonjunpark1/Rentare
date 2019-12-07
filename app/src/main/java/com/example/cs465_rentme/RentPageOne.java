package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RentPageOne extends AppCompatActivity implements View.OnClickListener {
    String name;
    String price;
    Integer image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_page_one);

        Button rent_page_one_button = findViewById(R.id.rent_page_one_button);
        rent_page_one_button.setOnClickListener(this);
        Intent intent = getIntent();
        String item_name = intent.getStringExtra("item_name");
        String item_price = intent.getStringExtra("item_price");
        String item_rating = intent.getStringExtra("item_rating");
        Integer item_image = intent.getIntExtra("item_image", 0);
        TextView item_name_price = findViewById(R.id.item_name_page);
        TextView item_rating_d = findViewById(R.id.item_rating_page);
        TextView item_description_d = findViewById(R.id.item_description_page);
        ImageView item_image_d = findViewById(R.id.item_image_page);
        item_name_price.setText(item_name + " - " + item_price);
        item_rating_d.setText(item_rating + " Reviews");
        item_description_d.setText("Lightly used " + item_name + "! About 5 years old, but only used twice a year. Let me know if you have further questions!");
        item_image_d.setImageResource(item_image);
        name = item_name;
        price = item_price;
        image = item_image;
    }

    public void onClick(View v) {
        Intent intent = new Intent(RentPageOne.this, rent_page_two.class);
        intent.putExtra("item_name", name);
        intent.putExtra("item_price", price);
        intent.putExtra("item_image", image);
        startActivity(intent);
    }
}
