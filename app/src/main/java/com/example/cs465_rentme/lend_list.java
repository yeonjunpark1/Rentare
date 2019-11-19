package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class lend_list extends AppCompatActivity implements View.OnClickListener {
    ListView lst;
    String[] items = {"Ladder", "Tennis Racket"};
    String[] description = {"Ladder is in good shape and is very sturdy. You can reach high places easily", "Slightly used Wilson tennis racket. Strings are in good condition and it comes with a grip tape on the handle"};
    Integer[] images = {R.drawable.ladder, R.drawable.wilson};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_list);
        Button b1 = findViewById(R.id.button_add_item);
        b1.setOnClickListener(this);

        lst= (ListView) findViewById(R.id.listview);
        lend_list_custom lend_list_custom = new lend_list_custom(this, items, description, images);
        lst.setAdapter(lend_list_custom);
    }
    public void onClick(View v){
        Intent intent = null;
        if (v.getId() == R.id.button_add_item) intent = new Intent(lend_list.this, activity_lend_form.class);
        startActivity(intent);
    }
}
