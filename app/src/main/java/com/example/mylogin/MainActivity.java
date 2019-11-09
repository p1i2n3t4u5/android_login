package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void sendUsernamePassword(View view){

       EditText usernameEditText=findViewById(R.id.username_id);
       String username=usernameEditText.getText().toString();

       EditText passwordEditText=findViewById(R.id.password_id);
       String password=passwordEditText.getText().toString();

       Intent intent=new Intent(this,DashboardActivity.class);
       intent.putExtra("USER_NAME_MESSAGE",username);
       intent.putExtra("PASSWORD_MESSAGE",password);

        startActivity(intent);
   }
}
