package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class rent_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_list);


        Spinner spinner = findViewById(R.id.category_spinner);
        Spinner sort_spin = findViewById(R.id.sort_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_choices,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_sort = ArrayAdapter.createFromResource(this, R.array.sort_choices,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_sort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sort_spin.setAdapter(adapter_sort);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        sort_spin.setOnItemSelectedListener(this);


        ImageView grill_photo = findViewById(R.id.grill_image_click);
        grill_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rent_list.this, RentPageOne.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
