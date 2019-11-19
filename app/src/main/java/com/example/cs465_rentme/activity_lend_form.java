package com.example.cs465_rentme;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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



        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendar_grid);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);
        List<Date> dates = datePicker.getSelectedDates();
        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
//                String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
//                Toast.makeText(activity_lend_form.this, selectedDate, Toast.LENGTH_SHORT).show();

//                Calendar calSelected = Calendar.getInstance();
//                calSelected.setTime(date);
//                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
    public void onClick(View v){
        Intent intent = null;
        if (v.getId() == R.id.button_finish_listing) intent = new Intent(activity_lend_form.this, activity_lend_confirmation.class);
        startActivity(intent);
    }
}
