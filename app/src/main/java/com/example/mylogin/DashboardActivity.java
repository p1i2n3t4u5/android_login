package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent=getIntent();
        String username = intent.getStringExtra("USER_NAME_MESSAGE");
        String password = intent.getStringExtra("PASSWORD_MESSAGE");

        TextView textView=findViewById(R.id.display_username_password_id);
        textView.setText(username+password);
    }
}
