package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class lend_list extends AppCompatActivity implements View.OnClickListener {
    ListView lst;
    String[] items = {"Ladder", "Tennis Racket"};
    String[] availability = {"RENTED", "AVAILABLE"};
    String[] price = {"$10 per day", "$15 per day"};
    Uri[] images = {Uri.parse("android.resource://com.example.cs465_rentme/drawable/ladder"), Uri.parse("android.resource://com.example.cs465_rentme/drawable/wilson")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> items2 = new ArrayList<String>(Arrays.asList(items));
        ArrayList<String> availability2 = new ArrayList<String>(Arrays.asList(availability));
        ArrayList<String> price2 = new ArrayList<String>(Arrays.asList(price));
        ArrayList<Uri> images2 = new ArrayList<Uri>(Arrays.asList(images));
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            items2.add(extras.getString("item_name"));
            availability2.add("AVAILABLE");
            price2.add("$" + extras.getString("item_price") + " per day");
            images2.add(Uri.parse(extras.getString("photo")));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_list);
        Button b1 = findViewById(R.id.button_add_item);
        b1.setOnClickListener(this);

        lst= (ListView) findViewById(R.id.listview);
        lend_list_custom lend_list_custom = new lend_list_custom(this, items2, price2, availability2, images2);
        lst.setAdapter(lend_list_custom);
    }
    public void onClick(View v){
        Intent intent = null;
        if (v.getId() == R.id.button_add_item) intent = new Intent(lend_list.this, activity_lend_form.class);
        startActivity(intent);
    }
}
