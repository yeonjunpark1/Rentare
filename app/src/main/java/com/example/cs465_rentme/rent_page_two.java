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
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class rent_page_two extends AppCompatActivity implements View.OnClickListener {
    String first_date;
    String second_date;
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
            TextView tv1 = findViewById(R.id.total_price);
            intent.putExtra("total_price", tv1.getText().toString());
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
                            if(dayOfMonth > 9) {
                                rent_start_date.setText((monthOfYear + 1) + "-" + dayOfMonth + "-" + year);
                            } else {
                                rent_start_date.setText((monthOfYear + 1) + "-" + "0" + dayOfMonth + "-" + year);
                            }
                            TextView tv2 = findViewById(R.id.rent_start_date);
                            TextView tv3 = findViewById(R.id.rent_end_date);
                            first_date = tv2.getText().toString();
                            second_date = tv3.getText().toString();
                            if(!first_date.equals("Start Date") && !second_date.equals("End Date")) {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu");
                                    LocalDate date1 = LocalDate.parse(first_date, formatter);
                                    LocalDate date2 = LocalDate.parse(second_date, formatter);
                                    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                                    if(daysBetween > 0) {
                                        long price = daysBetween * 20;
                                        TextView tv1 = findViewById(R.id.total_price);
                                        tv1.setText("Total Price: $" + price);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please Select Appropriate Dates", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
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
                            if(dayOfMonth > 9) {
                                rent_end_date.setText((monthOfYear + 1) + "-" + dayOfMonth + "-" + year);
                            } else {
                                rent_end_date.setText((monthOfYear + 1) + "-" + "0" + dayOfMonth + "-" + year);
                            }
                            TextView tv2 = findViewById(R.id.rent_start_date);
                            TextView tv3 = findViewById(R.id.rent_end_date);
                            first_date = tv2.getText().toString();
                            second_date = tv3.getText().toString();
                            if(!first_date.equals("Start Date") && !second_date.equals("End Date")) {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu");
                                    LocalDate date1 = LocalDate.parse(first_date, formatter);
                                    LocalDate date2 = LocalDate.parse(second_date, formatter);
                                    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                                    if(daysBetween > 0) {
                                        long price = daysBetween * 20;
                                        TextView tv1 = findViewById(R.id.total_price);
                                        tv1.setText("Total Price: $" + price);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please Select Appropriate Dates", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        }
                    }, year, month, day);
            datePickerDialog.show();

        }
    }
}