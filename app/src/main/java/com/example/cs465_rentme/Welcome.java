package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button loginButton = findViewById(R.id.login_button);
        TextView signupText = findViewById(R.id.sign_up_text_link);

        loginButton.setOnClickListener(this);
        signupText.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.login_button) intent = new Intent(Welcome.this, HomeScreen.class);
        else if (v.getId() == R.id.sign_up_text_link) intent = new Intent(Welcome.this, SignUp.class);
        startActivity(intent);
    }
}
