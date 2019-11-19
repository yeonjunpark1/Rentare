package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button signupButton = findViewById(R.id.sign_up_button);
        signupButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(SignUp.this, HomeScreen.class);
        startActivity(intent);
    }
}
