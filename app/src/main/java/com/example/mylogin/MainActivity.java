package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText,passwordEditText;
    private SharedPreferenceConfig sharedPreferenceConfig;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceConfig= new SharedPreferenceConfig(getApplicationContext());
        usernameEditText=findViewById(R.id.username_id);
        passwordEditText=findViewById(R.id.password_id);


        if (sharedPreferenceConfig.readLoginStatus()){
            Intent intent=new Intent(this,DashboardActivity.class);
            intent.putExtra("USER_NAME_MESSAGE",getResources().getString(R.string.user_name));
            intent.putExtra("PASSWORD_MESSAGE",getResources().getString(R.string.user_password));
            startActivity(intent);
            finish();
        }

    }


   public void sendUsernamePassword(View view){


       username=usernameEditText.getText().toString();
       password=passwordEditText.getText().toString();

       if (username.equals(getResources().getString(R.string.user_name))
               && password.equals(getResources().getString(R.string.user_password))){

           Intent intent=new Intent(this,DashboardActivity.class);
           intent.putExtra("USER_NAME_MESSAGE",username);
           intent.putExtra("PASSWORD_MESSAGE",password);
           startActivity(intent);

           sharedPreferenceConfig.writeLoginStatus(true);

           finish();

       }else{
           Toast.makeText(this,"Login Failed Try Again",Toast.LENGTH_SHORT).show();
           usernameEditText.setText("");
           passwordEditText.setText("");
       }






   }
}
