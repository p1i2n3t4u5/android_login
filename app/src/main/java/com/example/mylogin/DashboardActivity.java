package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    Button logoutBtn;
    Button dbActivityBtn;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME_MESSAGE");
        String password = intent.getStringExtra("PASSWORD_MESSAGE");

        TextView textView = findViewById(R.id.display_username_password_id);
        textView.setText(username + password);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());


        logoutBtn = findViewById(R.id.logout_id);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferenceConfig.writeLoginStatus(false);
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
                finish();
            }
        });


        dbActivityBtn = findViewById(R.id.db_activity_btn);
        dbActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, DbMainActivity.class));
                finish();
            }
        });


    }

    public void onFinalActivity(View view) {
        startActivity(new Intent(this, FinalActivity.class));
    }

    public void onDynamicFragment(View view) {
        startActivity(new Intent(this, DyanamicFragmentActivity.class));
    }
}
