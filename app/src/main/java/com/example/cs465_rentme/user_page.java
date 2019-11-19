package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_page extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        Button messageButton = findViewById(R.id.message_button);
        Button reviewButton = findViewById(R.id.review_button);

        messageButton.setOnClickListener(this);
        reviewButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.message_button) intent = new Intent(user_page.this, message.class);
        //else if (v.getId() == R.id.review_button) intent = new Intent(user_page.this, user_review.class);
        startActivity(intent);
    }
}
