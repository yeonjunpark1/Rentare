package com.example.cs465_rentme;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class activity_lend_form extends AppCompatActivity implements View.OnClickListener {
    ImageView photo;
    private static final int PICK_IMAGE = 100;
    Uri imageUri = Uri.parse("android.resource://com.example.cs465_rentme/drawable/camera");
    EditText item_name;
    EditText item_price;
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

        Button photo_button = findViewById(R.id.button_photo);
        photo_button.setOnClickListener(this);
        photo = findViewById(R.id.camera_photo);

        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v){
        Intent intent = null;
        if (v.getId() == R.id.button_finish_listing) {
            if(!item_name.getText().toString().matches("") && !item_price.getText().toString().matches("")) {
                intent = new Intent(activity_lend_form.this, activity_lend_confirmation.class);
                intent.putExtra("photo", imageUri.toString());
                intent.putExtra("item_name", item_name.getText().toString());
                intent.putExtra("item_price", item_price.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Please Fill All Fields", Toast.LENGTH_LONG).show();
            }
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
        } else if(v.getId() == R.id.button_photo) {
            openGallery();

        }
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            photo.setImageURI(imageUri);
        }

    }
}
