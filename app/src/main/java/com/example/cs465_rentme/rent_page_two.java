package com.example.cs465_rentme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class rent_page_two extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_page_two);

        Button rent_page_two_button = findViewById(R.id.reserve_button);
        rent_page_two_button.setOnClickListener(this);

        Button rent_start_date_button = findViewById(R.id.rent_start_date_button);
        Button rent_end_date_button = findViewById(R.id.rent_end_date_button);
        rent_start_date_button.setOnClickListener(this);
        rent_end_date_button.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        if(v.getId() == R.id.reserve_button) {
            Intent intent = new Intent(rent_page_two.this, rent_confirmation.class);
            startActivity(intent);
        } else if(v.getId() == R.id.rent_start_date_button){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(rent_page_two.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            TextView rent_start_date = findViewById(R.id.rent_start_date);
                            rent_start_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, year, month, day);
            datePickerDialog.show();
        } else if(v.getId() == R.id.rent_end_date_button) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(rent_page_two.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            TextView rent_end_date = findViewById(R.id.rent_end_date);
                            rent_end_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, year, month, day);
            datePickerDialog.show();
        }
    }
}
