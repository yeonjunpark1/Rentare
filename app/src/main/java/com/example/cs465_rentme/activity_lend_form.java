package com.example.cs465_rentme;

import androidx.annotation.NonNull;
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

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class activity_lend_form extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_form);


        Button b2 = findViewById(R.id.button_finish_listing);
        b2.setOnClickListener(this);
        Button end_date_button = findViewById(R.id.end_date_button);
        end_date_button.setOnClickListener(this);
        Button start_date_button = findViewById(R.id.start_date_button);
        start_date_button.setOnClickListener(this);


//        Date today = new Date();
//        Calendar nextYear = Calendar.getInstance();
//        nextYear.add(Calendar.YEAR, 1);
//
//        CalendarPickerView datePicker = findViewById(R.id.calendar_grid);
//        datePicker.init(today, nextYear.getTime())
//                .inMode(CalendarPickerView.SelectionMode.RANGE)
//                .withSelectedDate(today);
//        List<Date> dates = datePicker.getSelectedDates();
//        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(Date date) {
//            }
//
//            @Override
//            public void onDateUnselected(Date date) {
//
//            }
//        });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v){
        Intent intent = null;
        if (v.getId() == R.id.button_finish_listing) {
            intent = new Intent(activity_lend_form.this, activity_lend_confirmation.class);
            startActivity(intent);
        } else if(v.getId() == R.id.start_date_button){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(activity_lend_form.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            TextView start_date = findViewById(R.id.start_date);
                            start_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, year, month, day);
            datePickerDialog.show();
        } else if(v.getId() == R.id.end_date_button) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(activity_lend_form.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            TextView end_date = findViewById(R.id.end_date);
                            end_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, year, month, day);
            datePickerDialog.show();
        }
    }
}
